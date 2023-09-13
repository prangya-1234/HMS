package com.hms.bean;

import com.hms.entity.Payments;

import lombok.Data;

@Data
public class Paymentsinfo {

	
	private String id;
	private String customerId;
	private String date;
	private String amount;
	private String description;
	

public Payments convertToEntity() {
		
	Payments pay = new Payments();
			if(id!=null  && id!="0")			
			pay.setId(Long.valueOf(id));
			pay.setCustomerId(customerId); 
			pay.setDate(date);
			pay.setAmount(amount); 
			pay.setDescription(description); 
			 
			
			return pay;
	   }
	
	
	
}
