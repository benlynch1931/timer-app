package com.ar.config;

public enum TimeType {

    HOUR(0),
    MIN(1),
    SEC(2);

    private final int multiplier;

    TimeType(final int multiplier) {
        this.multiplier = multiplier;
    }

    public int times() {
        return multiplier;
    }
}
