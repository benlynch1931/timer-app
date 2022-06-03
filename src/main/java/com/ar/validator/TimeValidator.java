package com.ar.validator;

/**
 * @author Ben Lynch
 */
public class TimeValidator {

    /**
     * Hides implicit constructor
     */
    private TimeValidator() {}

    public static boolean validateTimeValues(String[] timeValues) {
        boolean isValid = true;
        for (final String val : timeValues) {
            try {
                System.out.println(val);
                Integer.parseInt(val);
            } catch(Exception e) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
