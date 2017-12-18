package com.ajsg2.minimaljava

import com.ajsg2.minimaljava.common.tokens.UnexpectedCharacterException
import com.ajsg2.minimaljava.lex.Lexer
import com.typesafe.scalalogging.Logger
import java.io.{BufferedReader, FileReader}

object MiniJavaC extends App {

	val logger = Logger(this.getClass.getName)

	logger.debug("MiniJavaC started")

	if (args.length == 0) {
		logger.error("Filename not provided")

	} else {
		val flags: Seq[String] = args.dropRight(1).toList

		if (flags.isEmpty) {
			logger.debug("No flags chosen")
		} else {
			logger.debug("Using flags: " + flags)
		}

		val reader = new BufferedReader(new FileReader(args.last))

		val lexer = new Lexer(reader)

		try {
			var token = lexer.yylex()

			while (token != null) {
				println(token)
				token = lexer.yylex()
			}
		} catch {
			case e: UnexpectedCharacterException => System.err.println(e.getMessage)
			case e: Exception => e.printStackTrace()
		}
	}
}
