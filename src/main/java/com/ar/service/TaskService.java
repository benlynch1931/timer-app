package com.ar.service;

import com.ar.dto.TaskDto;
import com.ar.mapper.TaskMapper;
import com.ar.repository.PresetRepo;
import com.ar.repository.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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

    /**
     * Gets and converts Task to DTO for display purposes
     * @param currentRecordViewService service to get id of current selected task
     * @return task DTO for displaying
     */
    public TaskDto getTaskForDisplay(CurrentRecordViewService currentRecordViewService) {
        return TaskMapper.mapToDto(currentRecordViewService.getTaskRecord());
    }

    /**
     * Creates or Updates task
     * @param task task to save()
     */
    public void saveOrUpdateTask(TaskDto task) {
        taskRepo.save(TaskMapper.mapToEntity(task));
    }

    public void deleteTask(TaskDto currentTask) {
        taskRepo.delete(TaskMapper.mapToEntity(currentTask));
    }
}
