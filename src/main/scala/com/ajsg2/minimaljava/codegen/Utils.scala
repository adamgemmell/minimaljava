package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import javassist.{ClassPool, CtClass, NotFoundException}
import scala.collection.JavaConverters._

package object Utils {

	// Stable identifiers for pattern matching
	final val intType = CtClass.intType
	final val charType = CtClass.charType
	final val longType = CtClass.longType
	final val doubleType = CtClass.doubleType
	final val booleanType = CtClass.booleanType
	final val voidType = CtClass.voidType


	// Node name to "java.package.structure"
	def getName(node: Node, logger: Logger): String = {
		if (node.getNodeId != NodeType.name) {
			logger.error("Internal error: Expected name, received " + node.getNodeId)
			System.exit(1)
		}

		val strings = node.getData.asInstanceOf[java.util.List[String]].asScala

		// Insert "." between each adjacent string, flatten
		strings.mkString(".")
	}

	// Above but for strings
	def getStructure(strings: Seq[String]): String = strings.mkString(".")

	/**
	  * Check that a node has a certain number of children. Errors likely if this is not true.
	  *
	  * @param n      The node
	  * @param i      The expected number of children
	  * @param logger The logger to report to
	  */
	def assertNumChildren(n: Node, i: Int, logger: Logger): Unit = {
		if (n.getChildren.asScala.lengthCompare(i) != 0) {
			logger.warn("Internal error: For node " + n.getType + " expected " + i +
					" children, found " + n.getChildren.size())
		}
	}

	/**
	  * Check that a node has a minimum number of children. Errors likely if this is not true.
	  *
	  * @param n      The node
	  * @param i      The minimum number of children
	  * @param logger The logger to report to
	  */
	def assertMinChildren(n: Node, i: Int, logger: Logger): Unit = {
		if (n.getChildren.asScala.lengthCompare(i) < 0) {
			logger.warn("Internal error: For node " + n.getType + " expected at least " + i +
					"children, found " + n.getChildren.size())
		}
	}

	/**
	  * Get the number of locla variables a type takes up.
	  *
	  * @param t The type
	  * @return
	  */
	def varSize(t: CtClass): Int =
		if (t == longType || t == doubleType) {
			2
		} else {
			1
		}

	/**
	  * Get a CtClass representing a class name
	  *
	  * @param className the class's name
	  * @param cp        class pool in which to search for classes
	  * @param logger    logger in which to report an error
	  * @return A CtClass
	  */
	def getCtClass(className: String, cp: ClassPool, logger: Logger): CtClass = {
		className match {
			case "int" => intType
			case "char" => charType
			case "long" => longType
			case "double" => doubleType
			case "boolean" => booleanType
			case _ => try {
				cp.get(className)
			} catch {
				case _: NotFoundException => logger
						.error("Could not find class " + className)
					System.exit(1)
					CtClass.voidType
			}
		}


	}
}
