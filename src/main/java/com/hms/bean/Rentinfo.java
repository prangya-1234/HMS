package com.hms.bean;

import com.hms.entity.Rent;

import lombok.Data;
@Data
public class Rentinfo {
	
	private String id;
	private String hostelId;
	private String title;
	private String amount;
	private String type;
	private String description;
	
public Rent convertToEntity() {
		Rent rent= new Rent();
			if(id!=null  && id!="0")			
			rent.setId(Long.valueOf(id)); 
		    rent.setHostelId(hostelId); 
			rent.setTitle(title); 
			rent.setAmount(amount);
			rent.setType(type);
			rent.setDescription(description); 

			return rent;
	   }	
}
