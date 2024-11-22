package com.mladmin.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mladmin.portal.entity.UserMaster;

import java.util.Optional;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {

    Optional<UserMaster> findByEmailId(String emailId);  
	Optional<UserMaster> findById(int id);
	 
}
