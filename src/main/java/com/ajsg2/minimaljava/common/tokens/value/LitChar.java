package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitChar extends ValueToken<Character> {

	public LitChar(int line, int col, Character val) {
		super(line, col, val);
	}
}
