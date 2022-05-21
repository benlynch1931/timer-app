package com.ar.utils;

import com.ar.entity.ActiveTask;
import com.ar.repository.ActiveTaskRepo;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

/**
 * @author Ben Lynch
 */
public class PresetUtils {

    private PresetUtils() {}

    /**
     * This method generates a timestamp based on duration for when the preset would be ready by - if started right now
     * @param duration
     * @return
     */
    public static LocalDateTime readyBy(BigInteger duration) {
         return LocalDateTime.now().plus(duration.longValue(), ChronoUnit.SECONDS);
    }

    public static String viewFormat(LocalDateTime timeToFormat) {
        return timeToFormat.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * Checks if task alarm should go off
     * @param activeTaskRepo repository of ActiveTask table
     * @param activePresetId presetId of active tasks to check
     */
    public static boolean checkTaskStatus(ActiveTaskRepo activeTaskRepo, BigInteger activePresetId) {
        List<ActiveTask> presetActiveTasks = activeTaskRepo.getByPresetId(activePresetId);
        if (presetActiveTasks.isEmpty()) {
            return true;
        } else {
            presetActiveTasks.forEach(task -> {
            if (task.getAlarmTime().isBefore(LocalDateTime.now())) {
                startAlarm(task.getName());
                activeTaskRepo.delete(task);
            }
            });
            return false;
        }
    }

    public static void startAlarm(String taskName) {
        System.out.println("Alarm ringing");
    }

}
