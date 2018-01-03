package com.ajsg2.minimaljava.common.tokens;

public abstract class ValueToken<T> implements Token {

	private final int line;
	private final int col;
	T val;

	protected ValueToken(int line, int col, T val) {
		this.line = line;
		this.col = col;
		this.val = val;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCol() {
		return col;
	}

	public T getValue() {
		return val;
	}

	public String toString() {
		return this.getClass().getSimpleName().toString() + ": " + val.toString();
	}
}
