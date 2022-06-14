package com.bl.repository;

import com.bl.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query("SELECT t FROM Task t WHERE t.presetId=:presetId ORDER BY t.duration DESC")
    List<Task> getByPresetId(BigInteger presetId);

    @Transactional
    @Query("SELECT t from Task t WHERE t.id=:taskId")
    Task getById(BigInteger taskId);
}
