package com.qa.springcars.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springcars.domain.CarTB;

@Repository
public interface CarTBRepo extends JpaRepository<CarTB, Long>{

	// JpaRepository - Existing API
	// CarDB -> Type of the Entity (Table)
	// Long -> Primary key type
	
}
