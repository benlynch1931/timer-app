package com.bl.validator;

/**
 * @author Ben Lynch
 */
public class NameValidator {

    /**
     * Hides implicit constructor
     */
    private NameValidator() {}

    /**
     * Validates if name is not null or empty
     * @param name name
     * @return true if valid name
     */
    public static boolean validateName(final String name) {
        if (name == null) {
            return false;
        }
        return !name.equals("");
    }
}
