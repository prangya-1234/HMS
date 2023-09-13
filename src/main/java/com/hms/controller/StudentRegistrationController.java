package com.hms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.hms.bean.StudentRegistrationinfo;
import com.hms.entity.StudentRegistration;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.StudentRegistrationRepo;
import com.hms.service.StudentRegistrationService;

@RestController
@RequestMapping("api/v1/student")
public class StudentRegistrationController {
	
	@Autowired
	StudentRegistrationService studentRegistrationService;
	@Autowired
	StudentRegistrationRepo studentRegistrationRepo;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	StudentRegistration register(@RequestBody StudentRegistrationinfo studentRegistrationinfo) {
		return studentRegistrationService.register(studentRegistrationinfo);		
	}
	 @GetMapping("/edit/{id}")
	 StudentRegistration update(@RequestBody StudentRegistration newUser, @PathVariable Long id) {
	        return studentRegistrationRepo.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setDob(newUser.getDob());
	                    user.setAge(newUser.getAge());
	                    user.setEmailId(newUser.getEmailId());
	                    user.setNationality(newUser.getPhoneNo());
	                    user.setPhoneNo(newUser.getPhoneNo());
	                    user.setAddress(newUser.getAddress());
	                    return studentRegistrationRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	 public List<StudentRegistration> getAll(){
		
		return studentRegistrationRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    StudentRegistration getUserById(@PathVariable Long id) {
        return studentRegistrationRepo.findById(id)
        		.orElseThrow(() -> new UserNotFoundException(id));
                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!studentRegistrationRepo.existsById(id)){
        	 throw new UserNotFoundException(id);
        }
        studentRegistrationRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}


