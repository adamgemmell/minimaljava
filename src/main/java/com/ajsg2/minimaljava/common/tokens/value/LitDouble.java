package com.ajsg2.minimaljava.common.tokens.value;

import com.ajsg2.minimaljava.common.tokens.ValueToken;

public class LitDouble extends ValueToken<Double> {

    private final Double val;

    public LitDouble(double val) {
        this.val = val;
    }

    @Override
    public Double getValue() {
        return val;
    }
}
