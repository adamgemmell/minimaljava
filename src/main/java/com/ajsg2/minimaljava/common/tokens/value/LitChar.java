package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitChar extends ValueToken<Character> {

    private final Character val;

    public LitChar(char val) {
        this.val = val;
    }

    @Override
    public Character getValue() {
        return val;
    }
}
