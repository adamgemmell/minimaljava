package com.ajsg2.minimaljava.common.tokens;

public abstract class ValueToken<T> implements Token {

	private final int line;
	private final int col;

	protected ValueToken(int line, int col) {
		this.line = line;
		this.col = col;
	}

	public abstract T getValue();

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCol() {
		return col;
	}
}
