package com.bl.entity;

import com.bl.config.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
