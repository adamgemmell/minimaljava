package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitInt extends ValueToken<Integer> {

    private final Integer val;

    public LitInt(int line, int col, int val) {
        super(line, col);
        this.val = val;
    }

    @Override
    public Integer getValue() {
        return val;
    }

    @Override
    public String toString(){
        return val.toString();
    }
}
