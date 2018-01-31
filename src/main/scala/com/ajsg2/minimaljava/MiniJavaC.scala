package com.ajsg2.minimaljava

import com.ajsg2.minimaljava.lex.Lexer
import com.ajsg2.minimaljava.parse.Parser
import com.typesafe.scalalogging.Logger
import java.io._
import java_cup.runtime
import java_cup.runtime.XMLElement

object MiniJavaC {


	def main(args: Array[String]): Unit = {

		val logger = Logger(this.getClass.getName)

		logger.debug("MiniJavaC started")

		var fileName: Option[String] = None
		var interactive = false

		args.foreach(a =>
			if (a.charAt(0) != '-') {
				fileName = Some(a)
				logger.debug("Filename: " + a)
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
				new BufferedReader(new FileReader(fileName.get))
			}

		//Debug test
		val p = new Parser(new Lexer(reader))
		p.debug_parse()

		//Produce AST
		//produceXML(reader)

		/* Lexer only
		val lexer = new Lexer(reader)
		var token: Token = null

		do {
			try {
				token = lexer.yylex()
				println(token)
			} catch {
				case e: UnexpectedCharacterException => logger.error(e.getMessage)
				case e: NumberFormatException => logger.error(e.getMessage)
				case e: Exception => logger.error(e.getMessage)
			}
		} while (token != null)*/
	}

	def produceXML(r: Reader): Unit = {
		import java.io.FileOutputStream
		import javax.xml.stream.XMLOutputFactory
		import javax.xml.transform.TransformerFactory
		import javax.xml.transform.stream.{StreamResult, StreamSource}

		val l = new Lexer(r)
		val p = new Parser(l)
		val lexer = new runtime.ScannerBuffer(l)

		val e: XMLElement = p.parse.value.asInstanceOf[XMLElement]
		// create XML output file
		val outFactory = XMLOutputFactory.newInstance
		val sw = outFactory.createXMLStreamWriter(new FileOutputStream("xml"))
		// dump XML output to the file
		XMLElement.dump(lexer, sw, e, "expr", "stmt")

		// transform the parse tree into an AST and a rendered HTML version
		var transformer = TransformerFactory.newInstance
				.newTransformer(new StreamSource(new File("tree.xsl")))
		var text = new StreamSource(new File("xml"))
		transformer.transform(text, new StreamResult(new File("output.xml")))
		transformer = TransformerFactory.newInstance
				.newTransformer(new StreamSource(new File("tree-view.xsl")))
		text = new StreamSource(new File("output.xml"))
		transformer.transform(text, new StreamResult(new File("ast.html")))
	}
}
