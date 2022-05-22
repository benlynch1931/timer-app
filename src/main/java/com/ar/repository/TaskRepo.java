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

    @Query("SELECT t FROM Task t WHERE t.presetId=:presetId")
    List<Task> getByPresetId(BigInteger presetId);
}
