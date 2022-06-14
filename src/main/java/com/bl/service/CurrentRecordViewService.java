package com.bl.service;

import com.bl.entity.ActiveTask;
import com.bl.entity.CurrentRecordView;
import com.bl.entity.Task;
import com.bl.repository.*;
import com.bl.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Ben Lynch
 */
@Component
@AllArgsConstructor
public class CurrentRecordViewService {


    private final CurrentRecordViewRepo currentRecordViewRepo;
    private final TaskRepo taskRepo;
    private final ActiveTaskRepo activeTaskRepo;

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
        if (Objects.equals(taskId, BigInteger.ZERO)) {
            Task newTask = new Task();
            newTask.setPresetId(currentRecordViewRepo.getRecordIdByScene("TASKLIST"));
            return newTask;
        }
        return taskRepo.getById(taskId);
    }

    public ActiveTask getAlarmRecord() {
        BigInteger alarmId = currentRecordViewRepo.getRecordIdByScene("ALARM");
        return activeTaskRepo.getById(alarmId);
    }

    public void removeRecord(final BigInteger id) {
        activeTaskRepo.delete(activeTaskRepo.getById(id));
    }
}
