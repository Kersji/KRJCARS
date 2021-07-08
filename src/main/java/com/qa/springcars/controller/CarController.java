package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController
public class CarController {

	// Mapping URLS to Methods

	List<Car> vehicles = new ArrayList<>();

	// CRUD functionality

	// Create
	@PostMapping("/createCar")
	public String createCar(@RequestBody Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}

	// Read - Use @GetMapping
	@GetMapping("/readCar")
	public List<Car> getAllCars() {
		return this.vehicles;
	}

	// Update - Put (Replace) / Patch (Update an element)
	@PatchMapping("/updateCar/{index}")
	public Car updateCar(
			@PathVariable int index, 
			@RequestBody Car newCar) {

		// replace the whole object at a specific index
		return this.vehicles.set(index, newCar);
	}
		
	// Delete - By Index
	// index variable in the mapping should have the
	// same name as the variable passed in the method
	@DeleteMapping("/removeCar/{index}")
	public Car removeCar(@PathVariable int index) {
		return this.vehicles.remove(index);
	}
	
}
