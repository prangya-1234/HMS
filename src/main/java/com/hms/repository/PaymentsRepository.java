package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Payments;

public interface  PaymentsRepository extends JpaRepository<Payments,Long>{

}
