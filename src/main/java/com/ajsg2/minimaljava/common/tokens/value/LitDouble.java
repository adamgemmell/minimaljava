package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitDouble extends ValueToken<Double> {

	public LitDouble(int line, int col, Double val) {
		super(line, col, val);
	}
}
