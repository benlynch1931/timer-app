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
        int timeOverZero = 0;
        for (final String val : timeValues) {
            try {
                timeOverZero += Integer.parseInt(val);
            } catch(Exception e) {
                isValid = false;
                break;
            }
        }
        return isValid && timeOverZero > 0;
    }
}
