package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hms.bean.StudentRegistrationinfo;
import com.hms.entity.StudentRegistration;
import com.hms.repository.StudentRegistrationRepo;


@Service
public class StudentRegistrationService {
@Autowired
	
    StudentRegistrationRepo StudentRegistrationRepo;

	public StudentRegistration register(StudentRegistrationinfo studentregistrationinfo) {
		return StudentRegistrationRepo.save(studentregistrationinfo.convertToEntity());
	}
	
	public StudentRegistration update(StudentRegistration studentregistration) {
		return StudentRegistrationRepo.save(studentregistration);
	}
	
	public List<StudentRegistration> getAll() {
		return StudentRegistrationRepo.findAll();
	}
	
	public Optional<StudentRegistration> getById(Long id) {
		return StudentRegistrationRepo.findById(id);
	}
	
}