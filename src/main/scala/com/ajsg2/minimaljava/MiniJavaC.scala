package com.ajsg2.minimaljava

import com.ajsg2.minimaljava.common.tokens.{Token, UnexpectedCharacterException}
import com.ajsg2.minimaljava.lex.Lexer
import com.typesafe.scalalogging.Logger
import java.io.{BufferedReader, FileReader, InputStreamReader, Reader}

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
		} while (token != null)
	}
}
