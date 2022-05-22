package com.ar.utils;

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
    public static boolean isNull(Object... objects) {
        boolean isNull = false;
        for (Object obj : objects) {
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
    public static boolean isNotNull(Object... objects) {
        return !isNull(objects);
    }
}
