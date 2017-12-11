package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitLong extends ValueToken<Long> {

    private final Long val;

    public LitLong(int line, int col, long val) {
        super(line, col);
        this.val = val;
    }

    @Override
    public Long getValue() {
        return val;
    }

    @Override
    public String toString(){
        return val.toString();
    }
}
