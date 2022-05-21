package com.ar.mapper;

import com.ar.dto.PresetDto;
import com.ar.entity.Preset;
import com.ar.utils.PresetUtils;

/**
 * @author Ben Lynch
 */
public class PresetMapper {

    private PresetMapper() {}

    public static PresetDto mapToDto(final Preset preset) {
        System.out.println(PresetUtils.viewFormat(PresetUtils.readyBy(preset.getDuration())));
        return PresetDto.builder()
                .id(preset.getId())
                .readyAt(PresetUtils.viewFormat(PresetUtils.readyBy(preset.getDuration())))
                .duration(preset.getDuration())
                .name(preset.getName())
                .taskList(TaskMapper.mapToDto(preset.getTaskList()))
                .build();
    }
}
