package com.ajsg2.minimaljava.common.tokens;

public abstract class SimpleToken implements Token {

	private final int line;
	private final int col;

	protected SimpleToken(int line, int col) {
		this.line = line;
		this.col = col;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return this.getClass().toString();
	}
}
