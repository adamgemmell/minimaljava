package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.Node
import com.ajsg2.minimaljava.parse.NonTerms
import com.typesafe.scalalogging.Logger
import java.io.{DataOutputStream, OutputStream}
import javassist.bytecode.{Bytecode, ClassFile, MethodInfo}
import scala.collection.JavaConverters._

class ClassGenerator(out: OutputStream, ast: Node) {

	val logger = Logger(this.getClass.getName)
	val dos = new DataOutputStream(out)

	def generate(): Unit = consumeClass(ast)

	private def consumeClass(node: Node): Unit = {
		node.getNodeId match {
			case NonTerms.classdef => val className: String = node.getData.asInstanceOf[String]
				val children = node.getChildren.asScala
				// First child is the superclass
				val superclass = getName(children.head)
				val cf = new ClassFile(false, className, superclass)

				// Other children are class members
				children.tail.foreach(consumeClassMember(_, cf))
				write(cf)
			case x => logger.error("nonterm " + NonTerms.ID(x) + " not implemented.")
		}
	}

	private def getName(node: Node): String = {
		if (node.getNodeId != NonTerms.name) {
			logger.error("Expected name, received " + NonTerms.ID(node.getNodeId))
		}

		val strings = node.getData.asInstanceOf[java.util.List[String]].asScala

		// Insert "." between each adjacent string, flatten
		strings.mkString(".")
	}

	private def consumeClassMember(node: Node, cf: ClassFile): Unit = {
		node.getNodeId match {
			case NonTerms.constructordef =>
				val code = new Bytecode(cf.getConstPool)
				code.addAload(0)
				code.addInvokespecial("java/lang/Object", MethodInfo.nameInit, "()V")
				code.addReturn(null)
				code.setMaxLocals(1)
				val minfo = new MethodInfo(cf.getConstPool, MethodInfo.nameInit, "()V")
				minfo.setCodeAttribute(code.toCodeAttribute)
				cf.addMethod(minfo)
			case x => logger.error("Expected class member, received " + NonTerms.ID(x))
		}
	}

	private def write(cf: ClassFile): Unit = {
		cf.compact()
		cf.write(dos)
		dos.close()
	}
}
