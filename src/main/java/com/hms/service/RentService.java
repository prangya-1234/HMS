package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hms.repository.RentRepository;
import com.hms.bean.Rentinfo;
import com.hms.entity.Rent;


@Service
public class RentService {

	@Autowired                 
    RentRepository RentRepository;

		public   Rent register(  Rentinfo Rentinfo) {
			return RentRepository.save(Rentinfo.convertToEntity());    
		}
		                                              
		public Rent update(Rent rent) {
			return RentRepository.save(rent); 
		}

		public List<Rent> getAll() {
			return RentRepository .findAll();
		}
		
		public Optional<Rent> getById(Long id) {
			return RentRepository.findById(id);
		
		}


}
