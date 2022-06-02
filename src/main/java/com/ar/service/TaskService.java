package com.ar.service;

import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.entity.Preset;
import com.ar.entity.Task;
import com.ar.mapper.PresetMapper;
import com.ar.mapper.TaskMapper;
import com.ar.repository.ActiveTaskRepo;
import com.ar.repository.PresetRepo;
import com.ar.repository.TaskRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Ben Lynch
 */
@Component
@AllArgsConstructor
public class TaskService {
    // TODO: Stop preset -> clear active timers

    private final PresetRepo presetRepo;

    private final TaskRepo taskRepo;

    private final ApplicationContext applicationContext;

//    public TaskService(PresetRepo presetRepo, ActiveTaskRepo activeTaskRepo, ApplicationContext applicationContext) {
//        this.presetRepo = presetRepo;
//        this.activeTaskRepo = activeTaskRepo;
//        this.applicationContext = applicationContext;
//    }

    /**
     * Formats list to be compatible with JavaFX
     * @param taskList list to format
     * @return JavaFx compatible list
     */
    private ObservableList<TaskDto> formatList(List<Task> taskList) {
        ObservableList<TaskDto> observableList = FXCollections.observableArrayList();
        taskList.forEach(task -> observableList.add(TaskMapper.mapToDto(task)));
        observableList.add(TaskDto.builder().name("New Task").build());
        return observableList;
    }

    public ObservableList<TaskDto> getTaskList(BigInteger presetId) {
        return formatList(taskRepo.getByPresetId(presetId));
    }

    public void saveOrUpdateTask(TaskDto task) {
        taskRepo.save(TaskMapper.mapToEntity(task));
    }

}
