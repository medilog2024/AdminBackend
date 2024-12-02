package com.mladmin.portal.repository;

import com.mladmin.portal.entity.SubscriptionMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionMasterRepository extends JpaRepository<SubscriptionMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }