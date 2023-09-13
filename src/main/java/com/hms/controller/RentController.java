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

import com.hms.bean.Rentinfo;
import com.hms.entity.Rent;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.RentRepository;
import com.hms.service.RentService;


@RestController
@RequestMapping("api/v1/rent")
public class RentController {
	@Autowired
	RentService rentService;
	@Autowired
	RentRepository rentRepository ;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Rent register(@RequestBody  Rentinfo rentinfo) {
		return rentService.register(rentinfo);		
	}
	 @GetMapping("/edit/{id}")
	 Rent update(@RequestBody Rent newUser, @PathVariable Long id) {
	        return rentRepository.findById(id)
	                .map(user -> {
	                    user.setHostelId(newUser.getHostelId());
	                    user.setTitle(newUser.getType());
	                    user.setAmount(newUser.getAmount());
	                    user.setType(newUser.getType());
	                    user.setDescription(newUser.getDescription());
	                    
	                 
	                   
	                    return rentRepository .save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<Rent> getAll(){
		
		return rentRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    Rent getUserById(@PathVariable Long id) {
        return rentRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!rentRepository.existsById(id)){
        	throw new UserNotFoundException(id);
        }
        rentRepository .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
}
