package com.bl.utils;

import com.bl.config.FormatType;
import com.bl.config.TimeValues;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
public class TimeUtils {

    /**
     * Hides implicit constructor
     */
    private TimeUtils() {}

    /**
     * Used to convert the duration of a task, in seconds, to an HH:mm:ss String
     * @param duration duration in seconds
     * @return HH:mm:ss string of duration
     */
    public static String convertSecondsToTime(BigInteger duration) {

        final double hoursAndMinutes = duration.doubleValue() / (double) TimeValues.TO_HOURS;
        double hoursAsDouble = Math.floor(hoursAndMinutes);

        final double minutesAndSeconds = (hoursAndMinutes - hoursAsDouble) * TimeValues.TO_MINUTES;
        double minutesAsDouble = Math.floor(minutesAndSeconds);

        double secondsAsDouble = (minutesAndSeconds - minutesAsDouble) * TimeValues.TO_SECONDS;

        int hours = (int) hoursAsDouble;
        int minutes = (int) minutesAsDouble;
        int seconds = (int) Math.round(secondsAsDouble);

        if (seconds == 60) {
            minutes += 1;
            seconds = 0;
        }
        if (minutes == 60) {
            hours += 1;
            minutes = 0;
        }

        final String hoursAsString = hours < 10 ? "0" + hours : String.valueOf(hours);
        final String minutesAsString = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        final String secondsAsString = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

        return hoursAsString.concat(":").concat(minutesAsString).concat(":").concat(secondsAsString);

    }



    /**
     * Replaces 00 with null for Task View, so placeholder shows instead of 0
     * @param duration Array of duration elements: hr,min,sec
     */
    public static String[] formatDurationText(final String[] duration, FormatType formatType) {
        for(int i=0; i<duration.length; i++) {
            if (formatType == FormatType.DISPLAY && duration[i].equals("00")) {
                duration[i] = null;
            } else if (formatType == FormatType.SAVE
                    && (ObjectUtils.isNull(duration[i]) || duration[i].equals(""))) {
                duration[i] = "00";
            }
        }
        return duration;
    }

    /**
     * Used to convert user's inputted time values to a seconds duration
     * @param time user's inputs
     * @return duration in seconds
     */
    public static BigInteger convertTimeToSeconds(final String[] time) {
        int hours = Integer.parseInt(time[0]) * TimeValues.TO_HOURS;
        int minutes = Integer.parseInt(time[1]) * TimeValues.TO_MINUTES;
        int seconds = Integer.parseInt(time[2]);
        return BigInteger.valueOf(hours + minutes + seconds);
    }
}
