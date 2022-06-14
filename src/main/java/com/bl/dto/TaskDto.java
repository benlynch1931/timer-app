package com.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDto {

    private BigInteger id;

    private BigInteger presetId;

    private String name;

    private BigInteger duration;
}
