package com.ajsg2.minimaljava.codegen

import java.io.{DataOutputStream, OutputStream}
import javassist.bytecode.ClassFile

import com.ajsg2.minimaljava.common.ast.Node
import com.ajsg2.minimaljava.parse.NonTerms
import com.typesafe.scalalogging.Logger

import scala.collection.JavaConverters._

class ClassGenerator(out: OutputStream, ast: Node) {

	val logger = Logger(this.getClass.getName)
	val dos = new DataOutputStream(out)

	def generate(): Unit = consumeClass(ast)

	def consumeClass(node: Node): Unit = {
		node.getNodeId match {
			case NonTerms.classdef => val className: String = node.getData.asInstanceOf[String]
				val superclass = getName(node.getChildren.get(0))
				val cf = new ClassFile(false, className, superclass)
			case x => logger.error("nonterm " + NonTerms.ID(x) + " not implemented.")
		}
	}

	def getName(node: Node): String = {
		if (node.getNodeId != NonTerms.name) {
			logger.error("Expected name, received " + NonTerms.ID(node.getNodeId))
		}

		val strings = node.getData.asInstanceOf[java.util.List[String]].asScala

		// Insert "." between each adjacent string
		(for (s <- strings; p <- List(".", s)) yield p).tail
		strings.mkString // To single string
	}
}
