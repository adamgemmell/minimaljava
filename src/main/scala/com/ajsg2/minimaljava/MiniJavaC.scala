package com.ajsg2.minimaljava

import com.ajsg2.minimaljava.codegen.ClassGenerator
import com.ajsg2.minimaljava.common.ast.Node
import com.ajsg2.minimaljava.lex.Lexer
import com.ajsg2.minimaljava.parse.Parser
import com.typesafe.scalalogging.Logger
import java.io._
import scala.collection.JavaConverters._

object MiniJavaC {

	var dir: Option[String] = None

	def main(args: Array[String]): Unit = {

		val logger = Logger(this.getClass.getName)

		logger.debug("MiniJavaC started")

		var fileName: Option[String] = None
		var interactive = false

		args.foreach(a =>
			if (a.charAt(0) != '-') {
				if (a.endsWith(".mj")) {
					fileName = Some(a.dropRight(3))
				} else {
					fileName = Some(a)
				}
				dir = Some(fileName.get.split("/").dropRight(1).mkString("/").concat("/"))
				logger.debug("Filename: " + fileName.get)
			} else if (a.equals("-interactive")) {
				interactive = true
				logger.debug("Using interactive mode")
			}
		)

		if (fileName.isEmpty && !interactive) {
			logger.error("No filename specified")
		}

		val reader: Reader =
			if (interactive) {
				new BufferedReader(new InputStreamReader(System.in))
			} else {
				new BufferedReader(new FileReader(fileName.get.concat(".mj")))
			}

		//Debug test
		val p = new Parser(new Lexer(reader))
		val ast: Seq[Node] = p.parse.value.asInstanceOf[java.util.List[Node]].asScala

		//ast.foreach(x => println(x.prettyPrint))

		ast.foreach(x => generate(x))
	}

	private def generate(node: Node): Unit = {
		// File path = dir + class name + ".class"
		val os = new BufferedOutputStream(
			new FileOutputStream(
				dir.get.concat(node.getData.asInstanceOf[String]).concat(".class")))
		val cg = new ClassGenerator(os, node)
		cg.generate()
	}
}
