package com.ar.entity;

import com.ar.config.DatabaseConstants;
import com.ar.utils.PresetUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = DatabaseConstants.TABLE_PRESET)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preset {

    public Preset(String name, BigInteger duration, List<Task> taskList) {
        this.name = name;
        this.duration = duration;
        this.taskList = taskList;
    }

    @Id
    @GeneratedValue
    @Column(name = DatabaseConstants.COLUMN_PRESET_ID)
    private BigInteger id;

    @Column(name = DatabaseConstants.COLUMN_NAME)
    private String name;

    @Column(name = DatabaseConstants.COLUMN_DURATION)
    private BigInteger duration;

    @JoinColumn(name = DatabaseConstants.COLUMN_PRESET_ID)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> taskList;

//    public String readyAt() {
//        return PresetUtils.viewFormat(PresetUtils.readyBy(duration));
//    }
}
