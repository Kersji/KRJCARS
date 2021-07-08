package com.qa.springcars.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springcars.domain.Car;

@Service // Contains main business logic of our application
public class CarServiceList {

	List<Car> vehicles = new ArrayList<>();
	
	// Methods to manipulate the list
	
	// CREATE - A method to add to the list
	public String createCar(Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}
	
	//READ - A method to read from the list
	public List<Car> getAllCars() {
		return this.vehicles;
	}
	
	// UPDATE - A method to replace an existing entry 
	public Car updateCar(int index, Car newCar) {

		// replace the whole object at a specific index
		return this.vehicles.set(index, newCar);
	}
	
	// DELETE - Remove an entry from the list
	public void removeCar(int index) {
		this.vehicles.remove(index);
	}
	
	// Display an entry from the list
	public Car retrieveCar(int index) {
		return this.vehicles.get(index);
	}
}
