package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.bean.HostelDetailsinfo;
import com.hms.entity.HostelDetails;
import com.hms.repository.HostelDetailsRepository;

@Service
public class HostelDetailsService {
	
@Autowired
	
	 HostelDetailsRepository HostelDetailsRepository;

		public HostelDetails register(HostelDetailsinfo hosteldetailsinfo) {
			return HostelDetailsRepository.save(hosteldetailsinfo.convertToEntity());
		}
		
		public HostelDetails update(HostelDetails hosteldetails) {
			return HostelDetailsRepository.save(hosteldetails);
		}
		
		public List<HostelDetails> getAll() {
			return HostelDetailsRepository.findAll();
		}
		
		public Optional<HostelDetails> getById(Long id) {
			return HostelDetailsRepository.findById(id);
		}
}
