package com.bms.blood.repo;

import com.bms.blood.model.BMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodRepo extends JpaRepository<BMS, Integer> {
    @Query("SELECT b FROM BMS b WHERE b.bloodgroup = :blood)")
    BMS findByBloodgroup(String blood);
}
