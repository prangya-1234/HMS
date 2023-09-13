package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.StudentRegistration;


public interface  StudentRegistrationRepo extends JpaRepository<StudentRegistration, Long>{

	

}
