package com.mladmin.portal.repository;

import com.mladmin.portal.entity.FAQMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQMasterRepository extends JpaRepository<FAQMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }