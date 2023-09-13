package com.hms.bean;

import com.hms.entity.StudentRegistration;

import lombok.Data;

@Data
public class StudentRegistrationinfo {

	private String id;
	private String name;
	private String age;
	private String dob;
	private String phoneNo;
	private String nationality;
	private String emailId;
	private String gender;
	private String address;

public StudentRegistration convertToEntity() {
		
	StudentRegistration student= new StudentRegistration();
			if(id!=null  && id!="0")			
			student.setId(Long.valueOf(id));
			student.setName(name); 
			student.setAge(age);
			student.setDob(dob); 
			student.setPhoneNo(phoneNo); 
			student.setNationality(nationality); 
			student.setEmailId(emailId); 
			student.setGender(gender); 
			student.setAddress(address); 
			
			return student;
	   }
}
