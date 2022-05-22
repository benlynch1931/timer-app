package com.ar.entity;

import com.ar.config.DatabaseConstants;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author Ben Lynch
 * Table to store the current record for TaskList and Task scenes
 */
@Entity
@Table(name = DatabaseConstants.TABLE_CURRENT_VIEW)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentRecordView {

    @Id
    @GeneratedValue
    @Column(name = DatabaseConstants.COLUMN_VIEW_ID)
    private BigInteger id;

    @Column(name = DatabaseConstants.COLUMN_SCENE)
    private String scene;

    @Column(name = DatabaseConstants.COLUMN_RECORD_ID)
    private BigInteger recordId;
}
