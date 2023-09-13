package com.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.bean.Paymentsinfo;
import com.hms.entity.Payments;
import com.hms.repository.PaymentsRepository;
@Service
public class PaymentsService {
@Autowired
	PaymentsRepository PaymentsRepository;

		public Payments register(Paymentsinfo paymentsinfo) {
			return PaymentsRepository.save(paymentsinfo.convertToEntity());
		}
		
		public Payments update(Payments payments) {
			return PaymentsRepository.save(payments);
		}
		
		public List<Payments> getAll() {
			return PaymentsRepository.findAll();
		}
		
		public Optional<Payments> getById(Long id) {
			return PaymentsRepository.findById(id);
		}
}
