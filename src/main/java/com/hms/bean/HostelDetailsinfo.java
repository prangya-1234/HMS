package com.hms.bean;

import com.hms.entity.HostelDetails;

import lombok.Data;
@Data
public class HostelDetailsinfo {

	private String id;
	private String name;
	private String type;
	private String rent;
	private String description;
	private String address;
	
public HostelDetails convertToEntity() {
		
	HostelDetails hostel= new HostelDetails();
			if(id!=null  && id!="0")			
			hostel.setId(Long.valueOf(id)); 
			hostel.setName(name); 
			hostel.setType(type);
			hostel.setRent(rent); 
			hostel.setDescription(description); 
			hostel.setAddress(address); 
			
			return hostel;
	   }	
	
	
	
}
