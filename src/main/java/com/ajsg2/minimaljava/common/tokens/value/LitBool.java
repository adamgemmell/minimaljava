package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitBool extends ValueToken<Boolean> {

	public LitBool(int line, int col, Boolean val) {
		super(line, col, val);
	}
}
