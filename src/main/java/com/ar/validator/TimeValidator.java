package com.ar.validator;

/**
 * @author Ben Lynch
 */
public class TimeValidator {

    /**
     * Hides implicit constructor
     */
    private TimeValidator() {}

    /**
     * Validates if time values are numbers
     * @param timeValues array of values
     * @return true if valid numbers
     */
    public static boolean validateTimeValues(String[] timeValues) {
        boolean isValid = true;
        boolean isZero = false;
        for (final String val : timeValues) {
            try {
                int integer = Integer.parseInt(val);
                if (!isZero) {
                    isZero = integer == 0;
                }
            } catch(Exception e) {
                isValid = false;
                break;
            }
        }
        return isValid && !isZero;
    }
}
