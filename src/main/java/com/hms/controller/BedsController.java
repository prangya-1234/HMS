package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.bean.Bedsinfo;
import com.hms.entity.Beds;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.BedsRepository;

import com.hms.service.BedsService;


@RestController
@RequestMapping("api/v1/beds")
public class BedsController {

	

	@Autowired
	BedsService bedsService;
	@Autowired
	BedsRepository bedsRepository ;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Beds register(@RequestBody  Bedsinfo bedsinfo) {
		return bedsService.register(bedsinfo);		
	}
	 @GetMapping("/edit/{id}")
	 Beds update(@RequestBody Beds newUser, @PathVariable Long id) {
	        return bedsRepository.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setType(newUser.getType());
	                    user.setDescription(newUser.getDescription());
	                    
	                 
	                   
	                    return bedsRepository .save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<Beds> getAll(){
		
		return bedsRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    Beds getUserById(@PathVariable Long id) {
        return bedsRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!bedsRepository.existsById(id)){
        	throw new UserNotFoundException(id);
        }
        bedsRepository .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
}
