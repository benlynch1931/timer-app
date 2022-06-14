package com.bl.mapper;

import com.bl.dto.TaskDto;
import com.bl.entity.Task;

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
                .presetId(task.getPresetId())
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

    /**
     * Maps Task DTO to entity for save or update in database
     * @param taskDto dto to get details from
     * @return entity for saving
     */
    public static Task mapToEntity(final TaskDto taskDto) {
        final Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDuration(taskDto.getDuration());
        task.setPresetId(taskDto.getPresetId());
        return task;
    }

    /**
     * Maps Task DTO List to entity for save or update in database
     * @param taskDtoList dto list to get details from
     * @return entity list for saving
     */
    public static List<Task> mapToEntity(final List<TaskDto> taskDtoList) {
        final List<Task> taskList = new ArrayList<>();
        taskDtoList.forEach(taskDto -> taskList.add(mapToEntity(taskDto)));
        return taskList;
    }
}
