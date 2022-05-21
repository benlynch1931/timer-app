package com.ar.dto;

import com.ar.config.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

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
