package com.ar.entity;

import com.ar.config.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Entity
@Table(name = DatabaseConstants.TABLE_TASK)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    public Task(String name, BigInteger duration) {
//        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @Column(name = DatabaseConstants.COLUMN_TASK_ID)
    private BigInteger id;

    @Column(name = DatabaseConstants.COLUMN_NAME)
    private String name;

    @Column(name = DatabaseConstants.COLUMN_DURATION)
    private BigInteger duration;
}
