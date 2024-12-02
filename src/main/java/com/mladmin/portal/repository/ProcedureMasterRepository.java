package com.mladmin.portal.repository;

import com.mladmin.portal.entity.ProcedureMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureMasterRepository extends JpaRepository<ProcedureMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }