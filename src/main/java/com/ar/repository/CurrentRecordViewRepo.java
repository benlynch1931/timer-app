package com.ar.repository;

import com.ar.entity.CurrentRecordView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

/**
 * @author Ben Lynch
 */
@Repository
public interface CurrentRecordViewRepo extends JpaRepository<CurrentRecordView, BigInteger> {

    @Query("SELECT r FROM CurrentRecordView r WHERE r.scene=:scene")
    Optional<CurrentRecordView> getByScene(String scene);

    @Query("SELECT r.recordId FROM CurrentRecordView r WHERE r.scene=:scene")
    BigInteger getRecordIdByScene(String scene);
}
