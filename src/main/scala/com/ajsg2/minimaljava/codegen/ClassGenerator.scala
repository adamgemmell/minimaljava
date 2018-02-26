package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.Node
import com.ajsg2.minimaljava.common.nonterminals
import com.typesafe.scalalogging.Logger

class ClassGenerator {

	val logger = Logger(this.getClass.getName)

	def parseNode(node: Node): Unit = {
		val x = node.getNodeId match {
			//case sym.classdef => ()
			case x => logger.error("nonterm " + nonterminals.nonterms(x) + " not implemented.")
		}
	}
}
