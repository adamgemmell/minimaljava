package com.ajsg2.minimaljava

import com.typesafe.scalalogging.{LazyLogging, Logger}

import scala.io.Source

object MiniJavaC extends App {
    val logger = Logger(this.getClass.getName)

    logger.debug("MiniJavaC started")

    if(args.length == 0) {
        logger.error("Filename not provided")

    } else {
        val flags: Array[String] = args.dropRight(1)

        if(flags.isEmpty)
            logger.debug("No flags chosen")
        else
            logger.debug("Using flags: " + flags)

        val file = Source.fromFile(args.last)
    }
}
