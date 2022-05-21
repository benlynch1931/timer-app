package com.ar.dto;

import com.ar.config.DatabaseConstants;
import com.ar.entity.Task;
import com.ar.utils.PresetUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


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
