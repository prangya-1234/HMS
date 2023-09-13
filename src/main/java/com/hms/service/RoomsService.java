package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.bean.Roomsinfo;
import com.hms.entity.Rooms;
import com.hms.repository.RoomsRepository;
@Service
public class RoomsService {

	
	@Autowired                 
    RoomsRepository roomsRepository;

		public   Rooms register(  Roomsinfo Roomsinfo) {
			return roomsRepository.save(Roomsinfo.convertToEntity());    
		}
		                                              
		public Rooms update(Rooms rooms) {
			return roomsRepository.save(rooms); 
		}

		public List<Rooms> getAll() {
			return roomsRepository .findAll();
		}
		
		public Optional<Rooms> getById(Long id) {
			return roomsRepository.findById(id);
		
		}
}
