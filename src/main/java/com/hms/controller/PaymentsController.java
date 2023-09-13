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

import com.hms.bean.Paymentsinfo;
import com.hms.entity.Payments;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.PaymentsRepository;
import com.hms.service.PaymentsService;



@RestController
@RequestMapping("api/v1/payments")
public class PaymentsController {
	@Autowired
	PaymentsService paymentsService;
	@Autowired
	PaymentsRepository paymentsRepository;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Payments register(@RequestBody Paymentsinfo paymentsinfo) {
		return paymentsService.register(paymentsinfo);		
	}
	 @GetMapping("/edit/{id}")
	 Payments update(@RequestBody Payments newUser, @PathVariable Long id) {
	        return paymentsRepository.findById(id)
	                .map(user -> {
	                    user.setCustomerId(newUser.getCustomerId());
	                    user.setAmount(newUser.getAmount());
	                    user.setDate(newUser.getDate());
	                    user.setDescription(newUser.getDescription());
	                    return paymentsRepository.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<Payments> getAll(){
		
		return paymentsRepository.findAll();
	}
	 
    @GetMapping("/get@All/{id}")
    Payments getUserById(@PathVariable Long id) {
        return paymentsRepository.findById(id)
        		.orElseThrow(() -> new UserNotFoundException(id));
                
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!paymentsRepository.existsById(id)){
        	throw new UserNotFoundException(id);
        }
        paymentsRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
