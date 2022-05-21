package com.ar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Ben Lynch
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PresetDto {

    private BigInteger id;

    private String name;

    private String readyAt;

    private BigInteger duration;

    private List<TaskDto> taskList;
}
