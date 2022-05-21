package com.ar.mapper;

import com.ar.dto.TaskDto;
import com.ar.entity.Task;
import com.ar.utils.PresetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Lynch
 */
public class TaskMapper {

    private TaskMapper() {}

    public static TaskDto mapToDto(final Task task) {
        System.out.println(PresetUtils.viewFormat(PresetUtils.readyBy(task.getDuration())));
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .duration(task.getDuration())
                .build();
    }

    public static List<TaskDto> mapToDto(final List<Task> taskList) {
        final List<TaskDto> dtoList = new ArrayList<>();
        taskList.forEach(task -> dtoList.add(mapToDto(task)));
        return dtoList;
    }
}
