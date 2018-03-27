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

	// Above but not only for nodes
	def getStructure(strings: Seq[String]): String = strings.mkString(".")

	def lct(t1: CtClass, t2: CtClass, logger: Logger): CtClass = {
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
	def varSize(t: java.lang.reflect.Type): Int = if (t == java.lang.Long.TYPE ||
			t == java.lang.Double.TYPE) {
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

	/**
	  * Get a CtClass representing a type
	  *
	  * @param varType the type
	  * @param cp      class pool in which to search for classes
	  * @param logger  logger in which to report an error
	  * @return A CtClass
	  */
	def getCtClass(varType: java.lang.reflect.Type, cp: ClassPool,
			logger: Logger): CtClass = {
		varType match {
			case java.lang.Integer.TYPE => CtClass.intType
			case java.lang.Character.TYPE => CtClass.charType
			case java.lang.Long.TYPE => CtClass.longType
			case java.lang.Double.TYPE => CtClass.doubleType
			case java.lang.Boolean.TYPE => CtClass.booleanType
			case _ => try {
				cp.get(varType.getTypeName)
			} catch {
				case _: NotFoundException => logger
						.error("Could not find class " + varType.getTypeName)
					System.exit(1)
					CtClass.voidType
			}
		}
	}
}
