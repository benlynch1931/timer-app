package com.ar.repository;

import com.ar.entity.Preset;
import com.ar.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Ben Lynch
 */
@Repository
public interface TaskRepo extends JpaRepository<Task, BigInteger> {

    @Transactional
    @Query("SELECT t FROM Task t WHERE t.presetId=:presetId")
    List<Task> getByPresetId(BigInteger presetId);

    @Transactional
    @Query("SELECT t from Task t WHERE t.id=:taskId")
    Task getById(BigInteger taskId);
}
