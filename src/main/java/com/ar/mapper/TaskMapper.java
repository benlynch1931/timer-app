package com.ar.mapper;

import com.ar.dto.TaskDto;
import com.ar.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Lynch
 */
public class TaskMapper {

    private TaskMapper() {}

    /**
     * Maps Task entity to a DTO for use in the application
     * @param task Entity object
     * @return DTO object
     */
    public static TaskDto mapToDto(final Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .duration(task.getDuration())
                .build();
    }

    /**
     * Loops taskList to map Entity to DTO (as above)
     * @param taskList list of task Entities
     * @return list of task DTOs
     */
    public static List<TaskDto> mapToDto(final List<Task> taskList) {
        final List<TaskDto> dtoList = new ArrayList<>();
        taskList.forEach(task -> dtoList.add(mapToDto(task)));
        return dtoList;
    }
}
