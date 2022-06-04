package com.ar.mapper;

import com.ar.dto.PresetDto;
import com.ar.entity.Preset;
import com.ar.utils.ObjectUtils;
import com.ar.utils.PresetUtils;

import java.math.BigInteger;
import java.util.Objects;

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
            if (Objects.equals(preset.getDuration(), BigInteger.ZERO)) {
                presetDto.setReadyAt("N/A");
            } else {
                presetDto.setReadyAt(PresetUtils.viewFormat(PresetUtils.readyBy(preset.getDuration())));
            }
        }
        if (ObjectUtils.isNotNull(preset.getTaskList())) {
            presetDto.setTaskList(TaskMapper.mapToDto(preset.getTaskList()));
        }

        return presetDto;
    }

    /**
     * Maps Preset Dto to entity for save or update in database
     * @param presetDto dto to get details from
     * @return entity for saving
     */
    public static Preset mapToEntity(final PresetDto presetDto) {
        final Preset preset = new Preset();
        preset.setId(presetDto.getId());
        preset.setName(presetDto.getName());
        preset.setDuration(presetDto.getDuration());
        preset.setTaskList(TaskMapper.mapToEntity(presetDto.getTaskList()));
        return preset;
    }
}
