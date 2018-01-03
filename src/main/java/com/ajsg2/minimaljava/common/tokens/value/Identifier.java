package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class Identifier extends ValueToken<String> {

	public Identifier(int line, int col, String val) {
		super(line, col, val);
	}
}
