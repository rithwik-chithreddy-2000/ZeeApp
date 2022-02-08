package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Register;

@Repository
public interface UserRepo extends JpaRepository<Register, Integer> {
	
//	Checking the email exists in the user table
	Boolean existsByEmail(String email);

}