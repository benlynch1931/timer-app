package com.ar.repository;

import com.ar.entity.Preset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Repository
public interface PresetRepo extends JpaRepository<Preset, BigInteger> {
}
