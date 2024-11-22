package com.mladmin.portal.repository;

import com.mladmin.portal.entity.HospitalMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalMasterRepository extends JpaRepository<HospitalMaster, Long> {
    
    // Custom method to find a Hospital by name
    HospitalMaster findByName(String name);
}
