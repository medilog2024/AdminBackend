package com.mladmin.portal.repository;

import com.mladmin.portal.entity.CategoryMaster;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, Integer> { 
    boolean existsById(int id); 
    void deleteById(int id);
 }