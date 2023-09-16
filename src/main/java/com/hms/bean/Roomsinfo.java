package com.hms.bean;


import com.hms.entity.Rooms;

import lombok.Data;
@Data
public class Roomsinfo {
	private String id;
	private String number;
	private String type;
	private String description;
	
public Rooms convertToEntity() {
	
	        Rooms room= new Rooms ();
			if(id!=null  && id!="0")			
			room.setId(Long.valueOf(id)); 
			room.setNumber(number); 
			room.setType(type); 
			room.setDescription(description); 

			return room;
			
	   }	
}
