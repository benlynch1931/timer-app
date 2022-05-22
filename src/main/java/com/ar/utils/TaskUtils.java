package com.ar.utils;

import com.ar.config.TimeValues;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.entity.ActiveTask;
import com.ar.repository.ActiveTaskRepo;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * @author Ben Lynch
 */
public class TaskUtils {

    private TaskUtils() {}

    public static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Task Done");
            cancel();
        }
    };

    /**
     * Created records for the tasks that have just become active
     * @param activeTaskRepo repository of ActiveTask table
     * @param taskList list of tasks to activate
     * @param preset preset of tasks
     * @return true if all tasks activated, false if not
     */
    public static boolean createActiveTasks(ActiveTaskRepo activeTaskRepo, List<TaskDto> taskList, PresetDto preset) {
        List<ActiveTask> savedList = new ArrayList<>();
        taskList.forEach(task -> {
            long delay = preset.getDuration().subtract(task.getDuration()).longValue();
            LocalDateTime alarmTime = LocalDateTime.now().plus(delay, ChronoUnit.SECONDS);
            savedList.add(activeTaskRepo.save(new ActiveTask(preset.getId(), task.getName(), alarmTime)));
        });
        return savedList.size() == taskList.size();
    }


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

        final int hours = (int) hoursAsDouble;
        final int minutes = (int) minutesAsDouble;
        final int seconds = (int) Math.round(secondsAsDouble);

        final String hoursAsString = hours < 10 ? "0" + hours : String.valueOf(hours);
        final String minutesAsString = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        final String secondsAsString = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

        return hoursAsString.concat(":").concat(minutesAsString).concat(":").concat(secondsAsString);

    }

}
