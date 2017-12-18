package com.ajsg2.minimaljava.common.tokens;

public class UnexpectedCharacterException extends Exception {

	public UnexpectedCharacterException(String err, int line, int col) {
		super("Unexpected character <" + err + "> at line " + (line + 1) + ", column " + (col + 1));
	}
}
