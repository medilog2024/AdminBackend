package com.mladmin.portal.repository;

import com.mladmin.portal.entity.ContactUsMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsMasterRepository extends JpaRepository<ContactUsMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }