package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import javassist.bytecode.{Bytecode, Descriptor, Opcode}
import javassist.{ClassPool, CtClass, NotFoundException}
import scala.collection.JavaConverters._
import scala.collection.mutable.{LinkedHashMap, ListBuffer, Map}

class BytecodeGenerator(
		statements: Seq[Node],
		bc: Bytecode,
		cp: ClassPool = new ClassPool(true),
		varMap: Map[String, (Int, CtClass)] = new LinkedHashMap[String, (Int, CtClass)]()
) {

	val logger = Logger(this.getClass.getName)

	def generate(): Bytecode = {
		statements.foreach(consumeStatement)
		bc
	}


	private def consumeStatement(stmt: Node): Unit = {
		stmt.getNodeId match {
			case NodeType.methodinv =>
				val ref = stmt.getData.asInstanceOf[java.util.List[String]].asScala
				getRef(ref.dropRight(1)) match {
					case Some(clazz) =>
						val argTypes = ListBuffer[CtClass]()
						stmt.getChildren.forEach(x => argTypes += evalExpression(x).orNull) // Args
					val argArray = argTypes.toArray

						try {
							val meth = clazz.getDeclaredMethod(ref.last, argArray)
							val desc = Descriptor.ofMethod(meth.getReturnType, argArray)
							bc.addInvokevirtual(clazz, ref.last, desc)
						} catch {
							case _: NotFoundException => logger.error(
								"Could not find method " + ref.last + " with this signature.")
						}

					case None => // TODO: static method
				}

			case NodeType.localvardef =>
				Utils.assertNumChildren(stmt, 1, logger)

				val varType = stmt.getChildren.get(0).getType

				val clazz = if (varType == null) {
					Utils.assertNumChildren(stmt, 1, logger)
					val clazzName = Utils
							.getName(stmt.getChildren.get(0).getChildren.get(0), logger)
					Utils.getCtClass(clazzName, cp, logger)
				} else {
					Utils.getCtClass(varType, cp, logger)
				}
				val name = Utils.getName(stmt.getData.asInstanceOf[Node], logger)
				val nextVarNum = bc.getMaxLocals

				varMap.get(name) match {
					case Some(_) => logger.error("Local variable " + name + " already exists.")
						System.exit(1)
					case None =>
						varMap += ((name, (nextVarNum, clazz)))
						bc.incMaxLocals(Utils.varSize(varType))
				}
			case NodeType.varassignment => val name = Utils
					.getName(stmt.getData.asInstanceOf[Node], logger)
				varMap.get(name) match {
					case None => logger.error("Variable " + name + " not found.")
						System.exit(1)
					case Some((loc, varClazz)) =>
						Utils.assertNumChildren(stmt, 1, logger)
						setVar(loc, varClazz, stmt.getChildren.get(0))
				}

			case x =>
				logger.error("Expected statement, received " + x)
				System.exit(1)
		}
	}

	private def setVar(loc: Int, varClazz: CtClass, value: Node): Unit = {

		val typeRHS: CtClass = evalExpression(value).getOrElse({
			System.exit(1)
			CtClass.voidType
		})

		if (varClazz != typeRHS) {
			logger.error("Mismatched type for assignment to local variable.")
			System.exit(1)
		}

		varClazz match {
			case Utils.intType =>
				bc.addIstore(loc)
			case Utils.charType =>
				bc.addIstore(loc)
			case Utils.longType =>
				bc.addLstore(loc)
			case Utils.doubleType =>
				bc.addDstore(loc)
			case Utils.booleanType =>
				bc.addIstore(loc)
			case _ => bc.addAstore(loc)
		}
	}

	private def evalExpression(node: Node): Option[CtClass] = {
		if (node.getNodeId != NodeType.expression) {
			logger.error("Error evaluating expression")
			None
		}

		Utils.assertNumChildren(node, 1, logger)
		eval(node.getChildren.get(0))
	}

	private def eval(exp: Node): Option[CtClass] = {
		exp.getNodeId match {
			case NodeType.lit =>
				exp.getType match {
					case java.lang.Integer.TYPE => bc
							.addIconst(exp.getData.asInstanceOf[java.lang.Integer])
						Some(CtClass.intType)
					case java.lang.Character.TYPE => bc
							.addIconst(exp.getData.asInstanceOf[java.lang.Character].charValue())
						Some(CtClass.charType)
					case java.lang.Long.TYPE => bc
							.addLconst(exp.getData.asInstanceOf[java.lang.Long])
						Some(CtClass.longType)
					case java.lang.Double.TYPE => bc
							.addDconst(exp.getData.asInstanceOf[java.lang.Double])
						Some(CtClass.doubleType)
					case java.lang.Boolean.TYPE =>
						val bool = exp.getData.asInstanceOf[java.lang.Boolean]
						if (bool) {
							bc.addIconst(1)
							Some(CtClass.booleanType)
						} else {
							bc.addIconst(0)
							Some(CtClass.booleanType)
						}
					case null => bc.add(Opcode.ACONST_NULL)
						Some(null)
					case _ => logger.error("What did you just give me")
						None
				}
			case NodeType.name => getRef(
				exp.getData.asInstanceOf[java.util.List[String]].asScala)
			case NodeType.infixop => Utils.assertNumChildren(exp, 2, logger)
				val t1 = eval(exp.getChildren.get(0)).get
				val t2 = eval(exp.getChildren.get(1)).get
				val t = Utils.lct(t1, t2, logger)

				if (t != t1) {
					logger.error("Oh god") // TODO: proper typing
				}
				addCast(t2, t)
				addOp(exp.getData.asInstanceOf[Node], t)
				Some(t)
			case _ => logger.error(
				"Expression of type " + exp.getNodeId + " either invalid or not implemented.")
				None
		}
	}

	/**
	  * Adds an operator of the specified type
	  *
	  * @param node the operator
	  * @param t    the type of the operator
	  */
	private def addOp(node: Node, t: CtClass): Unit = {
		node.getNodeId match {
			case NodeType.plus => t match {
				case Utils.charType => bc.add(Opcode.IADD)
				case Utils.intType => bc.add(Opcode.IADD)
				case Utils.longType => bc.add(Opcode.LADD)
				case Utils.doubleType => bc.add(Opcode.DADD)
			}
			case NodeType.minus => t match {
				case Utils.charType => bc.add(Opcode.ISUB)
				case Utils.intType => bc.add(Opcode.ISUB)
				case Utils.longType => bc.add(Opcode.LSUB)
				case Utils.doubleType => bc.add(Opcode.DSUB)
			}
			case NodeType.mult => t match {
				case Utils.charType => bc.add(Opcode.IMUL)
				case Utils.intType => bc.add(Opcode.IMUL)
				case Utils.longType => bc.add(Opcode.LMUL)
				case Utils.doubleType => bc.add(Opcode.DMUL)
			}
			case NodeType.div => t match {
				case Utils.charType => bc.add(Opcode.IDIV)
				case Utils.intType => bc.add(Opcode.IDIV)
				case Utils.longType => bc.add(Opcode.LDIV)
				case Utils.doubleType => bc.add(Opcode.DDIV)
			}
			case NodeType.mod => t match {
				case Utils.charType => bc.add(Opcode.IREM)
				case Utils.intType => bc.add(Opcode.IREM)
				case Utils.longType => bc.add(Opcode.LREM)
				case Utils.doubleType => bc.add(Opcode.DREM)
			}
			case NodeType.gt => t match {
				case Utils.charType => bc.add(Opcode.IADD)
				case Utils.intType => val basePC = bc.currentPc()
				//	bc.add
				case Utils.longType => bc.add(Opcode.LADD)
				case Utils.doubleType => bc.add(Opcode.DADD)
			}
			case _ => logger.error("Operation " + node.getNodeId + " not implemented.")
		}

	}

	/**
	  * Adds a cast from primitive t1 to primitive t2.
	  * Ignores booleans, and whether this is a widening or narrowing cast.
	  *
	  * @param t1 Cast from
	  * @param t2 Cast to
	  */
	private def addCast(t1: CtClass, t2: CtClass): Unit = {
		t1 match {
			case Utils.charType => t2 match {
				case Utils.charType =>
				case Utils.intType =>
				case Utils.longType => bc.add(Opcode.I2L)
				case Utils.doubleType => bc.add(Opcode.I2D)
			}
			case Utils.intType => t2 match {
				case Utils.charType => bc.add(Opcode.I2C)
				case Utils.intType =>
				case Utils.longType => bc.add(Opcode.I2L)
				case Utils.doubleType => bc.add(Opcode.I2D)
			}
			case Utils.longType => t2 match {
				case Utils.charType => bc.add(Opcode.I2L)
				case Utils.intType => bc.add(Opcode.I2L)
				case Utils.longType =>
				case Utils.doubleType => bc.add(Opcode.L2D)
			}
			case Utils.doubleType => t2 match {
				case Utils.charType => bc.add(Opcode.D2I)
					bc.add(Opcode.I2C)
				case Utils.intType => bc.add(Opcode.D2I)
				case Utils.longType => bc.add(Opcode.I2L)
				case Utils.doubleType =>
			}
		}
	}

	// Add getStatics until this reference is placed on the stack
	private def getRef(ref: Seq[String]): Option[CtClass] = {
		varMap.get(ref.head) match {
			case None => // Not local var
				val (clazz, rem) = search(ref, List())

				if (rem.isEmpty) {
					None // No static resource referenced
				} else {
					val fieldtype: CtClass = clazz.getField(rem.head).getType
					bc.addGetstatic(clazz, rem.head, Descriptor.of(fieldtype))

					val clazztype = rem.tail.foldLeft[CtClass](fieldtype) {
						(lastType: CtClass, currentField: String) =>
							val currentType = lastType.getField(currentField).getType
							bc.addGetfield(lastType, currentField, Descriptor.of(currentType))
							currentType
					}
					Some(clazztype)
				}
			case Some((loc, varClazz)) =>
				varClazz match {
					case Utils.intType =>
						bc.addIload(loc)
					case Utils.charType =>
						bc.addIload(loc)
					case Utils.longType =>
						bc.addLload(loc)
					case Utils.doubleType =>
						bc.addDload(loc)
					case Utils.booleanType =>
						bc.addIload(loc)
					case _ => bc.addAload(loc)
				}
				Some(varClazz)
		}
	}

	// Return class and remaining identifiers, if any
	private def search(ref: Seq[String], rem: Seq[String]): (CtClass, Seq[String]) = {
		if (ref.isEmpty) {
			logger.error("Could not find reference: " + Utils.getStructure(rem))
			System.exit(1)
			(null, null)
		} else {
			val clazz = cp.getOrNull(Utils.getStructure(ref))
			if (clazz == null) {
				search(ref.dropRight(1), ref.last +: rem)
			} else {
				(clazz, rem)
			}
		}
	}
}
