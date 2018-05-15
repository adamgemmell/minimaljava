package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.codegen.Utils.{charType, doubleType, intType, longType}
import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import javassist.CtClass
import scala.collection.mutable.{LinkedHashMap, Map}

object Typing {

	val logger = Logger(this.getClass.getName)

	def typeOf(node: Node): Unit = {
		node.getNodeId match {
			case NodeType.lit => // Type is already set
			case NodeType.infixop =>
				Utils.assertNumChildren(node, 2, logger)
				val l = node.getChildren.get(0)
				val r = node.getChildren.get(1)
				typeOf(l)
				typeOf(r)
				node.setType(lct(l.getType, r.getType))
			case NodeType.name => // Handled later
			case _ => logger
					.error("Expression " + node.getNodeId + " is either invalid or not implemented")
		}
	}

	def lct(t1: CtClass, t2: CtClass): CtClass = {
		// Our simplified primitive type conversion
		def typeOrder(t: CtClass): Int = t match {
			case `charType` => 0
			case `intType` => 1
			case `longType` => 2
			case `doubleType` => 3
			case _ => -1
		}

		val to1 = typeOrder(t1)
		val to2 = typeOrder(t2)
		if (to1 == -1 || to2 == -1) {
			logger.error("Cannot implicitly convert between " + t1 + " and " + t2 +
					". Try a manual cast if both are objects.")
			System.exit(1)
		}

		math.max(to1, to2) match {
			case 0 => charType
			case 1 => intType
			case 2 => longType
			case 3 => doubleType
			case _ => logger.error("waddafack")
				CtClass.voidType
		}

	}

}
