package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController

// Allows to indent the location with /res
// e.g. http://localhost:8080/res/readCar
@RequestMapping("/res")
public class CarControllerResEnt {

	// Mapping URLS to Methods

	List<Car> vehicles = new ArrayList<>();

	// CRUD functionality

	// Create
	@PostMapping("/createCar")
	public ResponseEntity<String> createCar(@RequestBody Car c) {
		this.vehicles.add(c);
		return new ResponseEntity<String>("Successfully added car",
				HttpStatus.CREATED);
		       // Status code 201
	}

	// Read - Use @GetMapping
	@GetMapping("/readCar")
	public ResponseEntity<List<Car>> getAllCars() {
		
		// return new ResponseEntity<List<Car>>
		// (this.vehicles,HttpStatus.OK);
		
		// ok -> Status 200 - Same as line above
		return ResponseEntity.ok(this.vehicles);
	}

	// Update - Put (Replace) / Patch (Update an element)
	@PatchMapping("/updateCar/{index}")
	public ResponseEntity<Car> updateCar(
			@PathVariable int index, 
			@RequestBody Car newCar) {

		// replace the whole object at a specific index
		
		// return ResponseEntity.ok(this.vehicles.set(index, newCar));
		return new ResponseEntity<Car>(this.vehicles.set(index, newCar),
				HttpStatus.ACCEPTED);
	            // Status code 202
	}
		
	// Delete - By Index
	// index variable in the mapping should have the
	// same name as the variable passed in the method
	@DeleteMapping("/removeCar/{index}")
	public ResponseEntity<Car> removeCar(@PathVariable int index) {
		return new ResponseEntity<Car>(this.vehicles.remove(index), 
				HttpStatus.NO_CONTENT);
	        	// Status code 204
	}
	
}
