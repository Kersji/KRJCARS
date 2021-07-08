package com.qa.springcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.CarTB;
import com.qa.springcars.service.CarServiceDB;


@RestController

// Allows to indent the location with /res
// e.g. http://localhost:8080/res/readCar
@RequestMapping("/DB")
public class CarControllerDB {

	// Mapping URLS to Methods
	
	private CarServiceDB service;
	
	// Pull down the object from the BeanBag
	
	@Autowired
	public CarControllerDB(CarServiceDB service) {
		this.service = service;
	}

	// CRUD functionality

	// Create
	@PostMapping("/createCar")
	public ResponseEntity<String> createCar(@RequestBody CarTB c) {
		this.service.createCar(c);
		return new ResponseEntity<String>("Successfully added car",
				HttpStatus.CREATED);
		       // Status code 201
	}

	// Read - Use @GetMapping
	@GetMapping("/readCar")
	public ResponseEntity<List<CarTB>> getAllCars() {
		
		// return new ResponseEntity<List<Car>>
		// (this.vehicles,HttpStatus.OK);
		
		// ok -> Status 200 - Same as line above
		return ResponseEntity.ok(this.service.getAllCars());
	}

	// Update - Put (Replace) / Patch (Update an element)
	@PatchMapping("/updateCar/{index}")
	public ResponseEntity<CarTB> updateCar(
			@PathVariable Long index, 
			@RequestBody CarTB newCar) {

		// replace the whole object at a specific index
		
		// return ResponseEntity.ok(this.vehicles.set(index, newCar));
		return new ResponseEntity<CarTB>(this.service.updateCar(index, newCar),
				HttpStatus.ACCEPTED);
	            // Status code 202
	}
			
	// Delete - By Index
	// index variable in the mapping should have the
	// same name as the variable passed in the method
	@DeleteMapping("/removeCar/{index}")
	public ResponseEntity<CarTB> removeCar(@PathVariable Long index) {
		this.service.removeCar(index);
		return new ResponseEntity<CarTB>(HttpStatus.NO_CONTENT);		
	}
		
	@DeleteMapping("/removeCar2/{index}")
	public ResponseEntity<CarTB> removeCar2(@PathVariable Long index) {
		CarTB deletedCar = this.service.retrieveCar(index);
		this.service.removeCar(index);
		return new ResponseEntity<CarTB>(deletedCar, HttpStatus.ACCEPTED);
	}

}
