package com.ajsg2.minimaljava.codegen

import com.ajsg2.minimaljava.common.ast.{Node, NodeType}
import com.typesafe.scalalogging.Logger
import javassist.{ClassPool, CtClass, NotFoundException}
import scala.collection.JavaConverters._

package object Utils {

	// Stable identifiers for patterh matching
	final val intType: CtClass = CtClass.intType
	final val charType = CtClass.charType
	final val longType = CtClass.longType
	final val doubleType = CtClass.doubleType
	final val booleanType = CtClass.booleanType
	final val voidType = CtClass.voidType


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
