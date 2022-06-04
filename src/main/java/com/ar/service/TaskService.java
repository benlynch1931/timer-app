package com.ar.service;

import com.ar.dto.TaskDto;
import com.ar.entity.Task;
import com.ar.mapper.TaskMapper;
import com.ar.repository.PresetRepo;
import com.ar.repository.TaskRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
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



//    public ObservableList<TaskDto> getTaskList(CurrentRecordViewService currentRecordViewService) {
//
//    }

    public TaskDto getTaskList(CurrentRecordViewService currentRecordViewService) {
        return TaskMapper.mapToDto(currentRecordViewService.getTaskRecord());
    }

    public void saveOrUpdateTask(TaskDto task) {
        taskRepo.save(TaskMapper.mapToEntity(task));
    }

}
