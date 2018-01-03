package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitLong extends ValueToken<Long> {

	public LitLong(int line, int col, Long val) {
		super(line, col, val);
	}
}
