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

import com.hms.bean.Wardeninfo;
import com.hms.entity.Warden;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.WardenRepository;
import com.hms.service.WardenService;

@RestController
@RequestMapping("api/v1/warden")
public class WardenController {

	@Autowired
	WardenService wardenService;
	@Autowired
	WardenRepository wardenRepository ;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Warden register(@RequestBody Wardeninfo wardeninfo) {
		return wardenService.register(wardeninfo);		
	}
	 @GetMapping("/edit/{id}")
	 Warden update(@RequestBody  Warden newUser, @PathVariable Long id) {
	        return wardenRepository.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setDob(newUser.getDob());
	                    user.setAge(newUser.getAge());
	                    user.setEmailId(newUser.getEmailId());
	                    user.setNationality(newUser.getPhoneNo());
	                    user.setPhoneNo(newUser.getPhoneNo());
	                    user.setAddress(newUser.getAddress());
	                    return wardenRepository.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<Warden> getAll(){
		
		return wardenRepository .findAll();
	}
	 
    @GetMapping("/getAll/{id}")
  Warden getUserById(@PathVariable Long id) {
        return wardenRepository.findById(id)
        		.orElseThrow(() -> new UserNotFoundException(id));
                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!wardenRepository.existsById(id)){
        	 throw new UserNotFoundException(id);
        }
        wardenRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
	
}
