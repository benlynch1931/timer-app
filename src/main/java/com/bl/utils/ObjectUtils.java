package com.bl.utils;

/**
 * @author Ben Lynch
 */
public class ObjectUtils {

    /**
     * Hides implicit constructor
     */
    private ObjectUtils() {}


    /**
     * checks if objects are null
     * Dynamic arguments
     * @param objects one or more objects to null-check
     * @return if any objects passed are null
     */
    public static boolean isNull(final Object... objects) {
        boolean isNull = false;
        for (final Object obj : objects) {
            if (obj == null) {
                isNull = true;
                break;
            }
        }
        return isNull;
    }

    /**
     * Checks if objects are NOT null
     * @param objects one or more objects to null-check
     * @return if any objects passed are NOT null
     */
    public static boolean isNotNull(final Object... objects) {
        return !isNull(objects);
    }
}
