package com.ar.repository;

import com.ar.entity.ActiveTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Ben Lynch
 */
@Repository
public interface ActiveTaskRepo extends JpaRepository<ActiveTask, BigInteger> {

    @Transactional
    @Query("SELECT t FROM ActiveTask t WHERE t.presetId=:presetId")
    List<ActiveTask> getByPresetId(BigInteger presetId);

    @Transactional
    @Query("SELECT t FROM ActiveTask t WHERE t.id=:id")
    ActiveTask getById(BigInteger id);
}
