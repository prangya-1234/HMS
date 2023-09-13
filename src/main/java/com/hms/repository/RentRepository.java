package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
