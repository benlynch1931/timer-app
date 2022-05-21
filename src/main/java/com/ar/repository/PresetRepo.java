package com.ar.repository;

import com.ar.entity.Preset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Repository
public interface PresetRepo extends JpaRepository<Preset, BigInteger> {

    @Modifying
    @Transactional
    @Query("DELETE FROM ActiveTask t WHERE t.presetId=:presetId")
    void deleteByPresetId(BigInteger presetId);
}
