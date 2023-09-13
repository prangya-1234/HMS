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

import com.hms.service.*;
import com.hms.bean.HostelDetailsinfo;
import com.hms.entity.HostelDetails;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.HostelDetailsRepository;

@RestController
@RequestMapping("api/v1/hosteldetails")

public class HostelDetailsController {

	
	
	@Autowired
	HostelDetailsService hostelDetailsService;
	@Autowired
	HostelDetailsRepository hostelDetailsRepository ;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	HostelDetails register(@RequestBody  HostelDetailsinfo hostelDetailsinfo) {
		return hostelDetailsService.register(hostelDetailsinfo);		
	}
	 @GetMapping("/edit/{id}")
	 HostelDetails update(@RequestBody HostelDetails newUser, @PathVariable Long id) {
	        return hostelDetailsRepository.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setType(newUser.getType());
	                    user.setRent(newUser.getRent());
	                    user.setDescription(newUser.getDescription());
	                    user.setAddress(newUser.getAddress());
	                   
	                    return hostelDetailsRepository .save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<HostelDetails> getAll(){
		
		return hostelDetailsRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    HostelDetails getUserById(@PathVariable Long id) {
        return hostelDetailsRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!hostelDetailsRepository.existsById(id)){
        	throw new UserNotFoundException(id);
        }
        hostelDetailsRepository .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
	
	
	
	
}
