package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitInt extends ValueToken<Integer> {

	public LitInt(int line, int col, Integer val) {
		super(line, col, val);
	}
}
