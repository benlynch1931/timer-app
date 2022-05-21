package com.ar.entity;

import com.ar.config.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author Ben Lynch
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = DatabaseConstants.TABLE_ACTIVE_TASK)
public class ActiveTask {

    @Id
    @GeneratedValue
    @Column(name = DatabaseConstants.COLUMN_ACTIVE_TASK_ID)
    private BigInteger id;

    @Column(name = DatabaseConstants.COLUMN_PRESET_ID)
    private BigInteger presetId;

    @Column(name = DatabaseConstants.COLUMN_NAME)
    private String name;

    @Column(name = DatabaseConstants.COLUMN_ALARM_TIME)
    private LocalDateTime alarmTime;

    public ActiveTask(BigInteger presetId, String name, LocalDateTime alarmTime) {
        this.presetId = presetId;
        this.name = name;
        this.alarmTime = alarmTime;
    }
}
