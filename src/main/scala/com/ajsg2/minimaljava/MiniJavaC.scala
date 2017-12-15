package com.ajsg2.minimaljava

import java.io.{BufferedReader, FileReader}

import com.typesafe.scalalogging.Logger

import com.ajsg2.minimaljava.lex.Lexer

object MiniJavaC extends App {
    val logger = Logger(this.getClass.getName)

    logger.debug("MiniJavaC started")

    if (args.length == 0) {
        logger.error("Filename not provided")

    } else {
        val flags: Seq[String] = args.dropRight(1).toList

        if (flags.isEmpty)
            logger.debug("No flags chosen")
        else
            logger.debug("Using flags: " + flags)

        val reader = new BufferedReader(new FileReader(args.last))

        val lexer = new Lexer(reader)

        var token = lexer.yylex()

        while (token != null) {
            print(token)
            token = lexer.yylex()
        }
    }
}
