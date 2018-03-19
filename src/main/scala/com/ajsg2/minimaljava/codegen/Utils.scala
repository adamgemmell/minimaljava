package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import scala.collection.JavaConverters._

package object Utils {

	// Node name to "java.package.structure"
	def getName(node: Node, logger: Logger): String = {
		if (node.getNodeId != NodeType.name) {
			logger.error("Internal error: Expected name, received " + node.getNodeId)
		}

		val strings = node.getData.asInstanceOf[java.util.List[String]].asScala

		// Insert "." between each adjacent string, flatten
		strings.mkString(".")
	}

	// Above but not only for nodes
	def getStructure(strings: Seq[String]): String = strings.mkString(".")

	// Error if there isn't the expected number of children
	def assertNumChildren(n: Node, i: Int, logger: Logger): Unit = {
		if (n.getChildren.asScala.lengthCompare(i) != 0) {
			logger.error("Internal error: For node " + n.getType + " expected " + i +
					"children, found " + n.getChildren.size())
		}
	}

	// Error if there aren't enough children
	def assertMinChildren(n: Node, i: Int, logger: Logger): Unit = {
		if (n.getChildren.asScala.lengthCompare(i) < 0) {
			logger.error("Internal error: For node " + n.getType + " expected at least " + i +
					"children, found " + n.getChildren.size())
		}
	}

	// Longs & doubles use 2 words
	def varSize(t: java.lang.reflect.Type): Int = if (t == java.lang.Long.TYPE ||
			t == java.lang.Double.TYPE) {
		2
	} else {
		1
	}
}
