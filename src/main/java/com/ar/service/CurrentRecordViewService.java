package com.ar.service;

import com.ar.entity.CurrentRecordView;
import com.ar.entity.Task;
import com.ar.repository.CurrentRecordViewRepo;
import com.ar.repository.PresetRepo;
import com.ar.repository.TaskRepo;
import com.ar.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;

/**
 * @author Ben Lynch
 */
@Component
@AllArgsConstructor
public class CurrentRecordViewService {


    private final CurrentRecordViewRepo currentRecordViewRepo;
    private final TaskRepo taskRepo;
    private final PresetRepo presetRepo;

    /**
     * Updates or created a record to store the record linked to a scene
     * @param scene scene name to search for
     * @param record id of record to update scene with
     * @return true if successful, false if not
     */
    public boolean updateRecord(final String scene, final BigInteger record) {
        CurrentRecordView recordToSave;
        CurrentRecordView returnedRecord;
        final Optional<CurrentRecordView> current = currentRecordViewRepo.getByScene(scene);
        if (current.isPresent()) {
            recordToSave = current.get();
            recordToSave.setScene(scene);
            recordToSave.setRecordId(record);
        } else {
            recordToSave = CurrentRecordView.builder()
                    .scene(scene)
                    .recordId(record)
                    .build();
        }
        returnedRecord = currentRecordViewRepo.save(recordToSave);
        return ObjectUtils.isNotNull(returnedRecord);
    }

    public BigInteger getTaskListRecordId() {
        return currentRecordViewRepo.getRecordIdByScene("TASKLIST");
    }

    public Task getTaskRecord() {
        BigInteger taskId = currentRecordViewRepo.getRecordIdByScene("TASK");
        return taskRepo.getById(taskId);
    }
}
