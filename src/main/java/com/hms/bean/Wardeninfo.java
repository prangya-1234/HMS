package com.hms.bean;

import com.hms.entity.Warden;

import lombok.Data;
@Data
public class Wardeninfo {

	private String id;
	private String name;
	private String age;
	private String dob;
	private String phoneNo;
	private String nationality;
	private String emailId;
	private String gender;
	private String address;

public Warden convertToEntity() {
		
    Warden warden= new Warden();
			if(id!=null  && id!="0")			
				warden.setId(Long.valueOf(id));
			warden.setName(name); 
			warden.setAge(age);
			warden.setDob(dob); 
			warden.setPhoneNo(phoneNo); 
			warden.setNationality(nationality); 
			warden.setEmailId(emailId); 
			warden.setGender(gender); 
			warden.setAddress(address); 
			
			return warden;
	   }
	
}
