package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitChar extends ValueToken<Character> {

    private final Character val;

    public LitChar(int line, int col, char val) {
        super(line, col);
        this.val = val;
    }

    @Override
    public Character getValue() {
        return val;
    }
}
