package com.mladmin.portal.repository;

import com.mladmin.portal.entity.PrivacyPolicyMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivacyPolicyMasterRepository extends JpaRepository<PrivacyPolicyMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }