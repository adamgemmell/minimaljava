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
		varMap: Map[String, Int] = new LinkedHashMap[String, Int]()) {

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
						stmt.getChildren.forEach(x => argTypes += getArg(x).orNull) // Args
					val argArray = argTypes.toArray

						try {
							val meth = clazz.getDeclaredMethod(ref.last, argArray)
							val desc = Descriptor.ofMethod(meth.getReturnType, argArray)
							bc.addInvokevirtual(clazz, ref.last, desc)
						} catch {
							case nfe: NotFoundException => logger.error(
								"Could not find method " + ref.last + " with this signature.")
						}

					case None => // TODO: static method
				}

			case x =>
				logger.error("Expected statement, received " + x)
				System.exit(1)
		}
	}

	// Puts the required arg onto the stack
	private def getArg(arg: Node): Option[CtClass] = {
		arg.getNodeId match {
			case NodeType.lit =>
				arg.getType match {
					case java.lang.Integer.TYPE => bc
							.addIconst(arg.getData.asInstanceOf[java.lang.Integer])
						Some(CtClass.intType)
					case java.lang.Character.TYPE => bc
							.addIconst(arg.getData.asInstanceOf[java.lang.Character].charValue())
						Some(CtClass.charType)
					case java.lang.Long.TYPE => bc
							.addLconst(arg.getData.asInstanceOf[java.lang.Long])
						Some(CtClass.longType)
					case java.lang.Double.TYPE => bc
							.addDconst(arg.getData.asInstanceOf[java.lang.Double])
						Some(CtClass.doubleType)
					case java.lang.Boolean.TYPE =>
						val bool = arg.getData.asInstanceOf[java.lang.Boolean]
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
			case NodeType.name => getRef(arg.getData.asInstanceOf[java.util.List[String]].asScala)
			case _ => logger.error("What did you just give me")
				None
		}
	}

	// Add getStatics until this reference is placed on the stack
	private def getRef(ref: Seq[String]): Option[CtClass] = {
		varMap.get(ref.head) match {
			case None => // Not local var
				val (clazz, rem) = search(ref, List())

				if (rem.isEmpty) {
					None  // No static resource referenced
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
			case Some(x) => None// TODO: var
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
