package com.bl.service;

import com.bl.dto.TaskDto;
import com.bl.mapper.TaskMapper;
import com.bl.repository.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@AllArgsConstructor
public class TaskService {
    // TODO: Stop preset -> clear active timers

    private final TaskRepo taskRepo;

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
