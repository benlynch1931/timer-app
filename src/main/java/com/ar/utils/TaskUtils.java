package com.ar.utils;

import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.entity.ActiveTask;
import com.ar.repository.ActiveTaskRepo;
import javafx.scene.control.Alert;

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
}
