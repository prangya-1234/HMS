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

import com.hms.bean.Roomsinfo;
import com.hms.entity.Rooms;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.RoomsRepository;
import com.hms.service.RoomsService;
@RestController
@RequestMapping("api/v1/rooms")
public class RoomsController {   

	@Autowired
	RoomsService roomsService;
	@Autowired 
	RoomsRepository roomsRepository ; 
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)  
	Rooms register(@RequestBody  Roomsinfo roomsinfo) {
		return roomsService.register(roomsinfo);		
	}
	 @GetMapping("/edit/{id}")
	 Rooms update(@RequestBody Rooms newUser, @PathVariable Long id) {
	        return roomsRepository.findById(id)
	                .map(user -> {
	                    user.setNumber(newUser.getNumber());
	                    user.setType(newUser.getType());
	                    user.setDescription(newUser.getDescription());
	                    
	                 
	                   
	                    return roomsRepository .save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<Rooms> getAll(){
		
		return roomsRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    Rooms getUserById(@PathVariable Long id) {
        return roomsRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!roomsRepository.existsById(id)){
        	throw new UserNotFoundException(id);
        }
        roomsRepository .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
}
