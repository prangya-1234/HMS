package com.hms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hms.repository.BedsRepository;
import com.hms.bean.Bedsinfo;
import com.hms.entity.Beds;
@Service
public class BedsService {
                                                 
	  @Autowired                 
      BedsRepository BedsRepository;

		public   Beds register(  Bedsinfo Bedsinfo) {
			return BedsRepository.save(Bedsinfo.convertToEntity());    
		}
		                                              
		public Beds update(Beds hosteldetails) { 
			return BedsRepository.save(hosteldetails);
		}
		public Optional<Beds> getById(Long id) {
			return BedsRepository.findById(id);
		
		}
}
