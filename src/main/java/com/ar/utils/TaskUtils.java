package com.ar.utils;

import com.ar.config.FormatType;
import com.ar.config.TimeValues;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.entity.ActiveTask;
import com.ar.entity.Task;
import com.ar.mapper.TaskMapper;
import com.ar.repository.ActiveTaskRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigInteger;
import java.time.LocalDateTime;
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
     * Formats list to be compatible with JavaFX
     * @param taskList list to format
     * @return JavaFx compatible list
     */
    public static ObservableList<TaskDto> formatList(List<TaskDto> taskList) {
        ObservableList<TaskDto> observableList = FXCollections.observableArrayList();
        observableList.addAll(taskList);
        observableList.add(TaskDto.builder().name("New Task").build());
        return observableList;
    }

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
