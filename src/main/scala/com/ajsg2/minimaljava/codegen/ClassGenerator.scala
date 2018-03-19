package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import java.io.{DataOutputStream, OutputStream}
import javassist.bytecode._
import javassist.{ClassPool, CtClass}
import scala.collection.JavaConverters._

class ClassGenerator(out: OutputStream, ast: Node) {

	val logger: Logger = Logger(this.getClass.getName)
	val dos = new DataOutputStream(out)
	val cp = new ClassPool(true)

	def generate(): Unit = {
		consumeClass(ast)
	}

	private def consumeClass(node: Node): Unit = {
		node.getNodeId match {
			case NodeType.classdef => val className: String = node.getData.asInstanceOf[String]
				val children = node.getChildren.asScala
				// First child is the superclass
				val superclass = Utils.getName(children.head, logger)
				val cf = new ClassFile(false, className, superclass)

				// Other children are class members
				children.tail.foreach(consumeClassMember(_, cf))
				write(cf)
			case x => logger.error("nodetype " + x + " not implemented.")
		}
	}

	private def consumeClassMember(node: Node, cf: ClassFile): Unit = {
		node.getNodeId match {
			case NodeType.constructordef =>
				// TODO: params
				val code = new Bytecode(cf.getConstPool)
				code.addAload(0) // this
				code.addInvokespecial(cf.getSuperclass, MethodInfo.nameInit,
					Descriptor.ofConstructor(null))
				code.addReturn(null)
				code.setMaxLocals(1)
				val minfo = new MethodInfo(cf.getConstPool, MethodInfo.nameInit,
					Descriptor.ofConstructor(null))
				minfo.setCodeAttribute(code.toCodeAttribute)
				cf.addMethod(minfo)
			case NodeType.main =>
				val minfo = new MethodInfo(cf.getConstPool, "main",
					Descriptor.ofMethod(CtClass.voidType,
						Array(cp.get("java.lang.String[]"))))
				minfo.setAccessFlags(AccessFlag.setPublic(AccessFlag.STATIC))

				Utils.assertNumChildren(node, 1, logger)
				// Block statements
				val statements = node.getChildren.get(0).getChildren.asScala
				val code = new Bytecode(cf.getConstPool)
				code.incMaxLocals(1)
				new BytecodeGenerator(statements, code, cp).generate()
				code.addReturn(CtClass.voidType)

				minfo.setCodeAttribute(code.toCodeAttribute)
				cf.addMethod(minfo)

			case x => logger.error("Expected class member, received " + x)
		}
	}

	private def write(cf: ClassFile): Unit = {
		cf.compact()
		cf.write(dos)
		dos.close()
	}
}
