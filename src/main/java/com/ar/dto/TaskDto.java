package com.ar.dto;

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

    public TaskDto(String name, BigInteger duration) {
//        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    private BigInteger id;

    private String name;

    private BigInteger duration;
}
