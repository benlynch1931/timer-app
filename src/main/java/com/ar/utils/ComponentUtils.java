package com.ar.utils;

/**
 * @author Ben Lynch
 */
public class ComponentUtils {

    /**
     * Hides implicit constructor
     */
    private ComponentUtils() {}

    public static double twentyPct(final long value) {
        return value * 0.2;
    }
    public static double fiftyPct(final long value) {
        return value * 0.5;
    }
}
