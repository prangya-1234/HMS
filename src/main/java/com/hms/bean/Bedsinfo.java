package com.hms.bean;

import com.hms.entity.Beds;

import lombok.Data;
@Data
public class Bedsinfo {

	private String id;
	private String name;
	private String type;
	private String description;
	
public Beds convertToEntity() {
		Beds bed= new Beds();
			if(id!=null  && id!="0")			
			bed.setId(Long.valueOf(id)); 
			bed.setName(name); 
			bed.setType(type); 
			bed.setDescription(description); 

			return bed;
	   }	

}
