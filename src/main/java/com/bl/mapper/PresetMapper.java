package com.bl.mapper;

import com.bl.dto.PresetDto;
import com.bl.entity.Preset;
import com.bl.utils.ObjectUtils;
import com.bl.utils.PresetUtils;

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
        presetDto.setDelay(preset.getDelay());

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
        preset.setDelay(presetDto.getDelay());
        preset.setTaskList(TaskMapper.mapToEntity(presetDto.getTaskList()));
        return preset;
    }
}
