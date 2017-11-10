package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitBool extends ValueToken<Boolean> {

    private final Boolean val;

    public LitBool(int line, int col, boolean val) {
        super(line, col);
        this.val = val;
    }

    @Override
    public Boolean getValue() {
        return val;
    }
}
