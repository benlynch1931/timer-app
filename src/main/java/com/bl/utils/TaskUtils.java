package com.bl.utils;

import com.bl.config.DisplayType;
import com.bl.dto.PresetDto;
import com.bl.dto.TaskDto;
import com.bl.entity.ActiveTask;
import com.bl.repository.ActiveTaskRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ben Lynch
 */
public class TaskUtils {

    /**
     * Hides implicit constructor
     */
    private TaskUtils() {}

    /**
     * Formats list to be compatible with JavaFX
     * @param taskList list to format
     * @return JavaFx compatible list
     */
    public static ObservableList<TaskDto> formatList(List<TaskDto> taskList, DisplayType displayType) {
        ObservableList<TaskDto> observableList = FXCollections.observableArrayList();
        observableList.addAll(taskList);
        if (displayType == DisplayType.ADD) {
            observableList.add(TaskDto.builder().name("New Task").build());
        }
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
        if (Objects.equals(preset.getDelay(), BigInteger.ZERO)) {
            taskList.set(0, new TaskDto(null, preset.getId(), "Food is Ready", BigInteger.ZERO));
        } else {
            taskList.add(new TaskDto(null, preset.getId(), "Food is Ready", BigInteger.ZERO));
        }
        taskList.forEach(task -> {
            long delay = preset.getDuration().subtract(task.getDuration()).longValue();
            LocalDateTime alarmTime = LocalDateTime.now().plus(delay, ChronoUnit.SECONDS);
            savedList.add(activeTaskRepo.save(new ActiveTask(preset.getId(), task.getName(), alarmTime)));
        });
        return savedList.size() == taskList.size();
    }




}
