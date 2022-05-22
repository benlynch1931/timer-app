package com.ar.mapper;

import com.ar.dto.PresetDto;
import com.ar.entity.Preset;
import com.ar.utils.ObjectUtils;
import com.ar.utils.PresetUtils;

/**
 * @author Ben Lynch
 */
public class PresetMapper {

    private PresetMapper() {}

    /**
     * Maps Preset entity to a DTO for use in the application
     * @param preset Entity object
     * @return DTO object
     */
    public static PresetDto mapToDto(final Preset preset) {
        final PresetDto presetDto = new PresetDto();

        presetDto.setId(preset.getId());
        presetDto.setName(preset.getName());
        presetDto.setDuration(preset.getDuration());

        if (ObjectUtils.isNotNull(preset.getDuration())) {
            presetDto.setReadyAt(PresetUtils.viewFormat(PresetUtils.readyBy(preset.getDuration())));
        }
        if (ObjectUtils.isNotNull(preset.getTaskList())) {
            presetDto.setTaskList(TaskMapper.mapToDto(preset.getTaskList()));
        }

        return presetDto;
    }
}
