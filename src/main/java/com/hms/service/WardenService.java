package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.repository.*;
import com.hms.bean.Wardeninfo;
import com.hms.entity.Warden;

@Service
public class WardenService {
    
	@Autowired
	WardenRepository WardenRepository;

	public Warden register(Wardeninfo wardeninfo) {
		return WardenRepository.save(wardeninfo.convertToEntity());
	}
	
	public Warden update(Warden warden) {
		return WardenRepository.save(warden);
	}
	
	public List<Warden> getAll() {
		return WardenRepository .findAll();
	}
	
	public Optional<Warden> getById(Long id) {
		return WardenRepository .findById(id);
	}
	
	
}
