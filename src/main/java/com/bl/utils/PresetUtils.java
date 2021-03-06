package com.bl.utils;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Ben Lynch
 */
public class PresetUtils {

    private PresetUtils() {}

    /**
     * This method generates a timestamp based on duration for when the preset would be ready by - if started right now
     * @param duration duration of preset, in seconds
     * @return Time preset will be ready by
     */
    public static LocalDateTime readyBy(BigInteger duration) {
         return LocalDateTime.now().plus(duration.longValue(), ChronoUnit.SECONDS);
    }

    /**
     * Formats LocalDateTime to an HH:mm view for the user
     * @param timeToFormat time that needs formatting
     * @return formatted time as String
     */
    public static String viewFormat(LocalDateTime timeToFormat) {
        return timeToFormat.format(DateTimeFormatter.ofPattern("HH:mm"));
    }




}
