package com.qa.springcars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springcars.domain.CarTB;
import com.qa.springcars.repo.CarTBRepo;

@Service  // Business logic
public class CarServiceDB {

	// Dependency
	private CarTBRepo repo;
	
	@Autowired
	public CarServiceDB(CarTBRepo repo) {
		this.repo = repo;
	}
	
	// CRUD
		
	// CREATE = A method to add to the DB
	public String createCar(CarTB c) {
		this.repo.saveAndFlush(c);
		// INSERT INTO CAR('make', 'model', 'engine', 'spoiler' 
		// VALUES (c.getMake(), c.getModel(), c.getengine()), 
		// c.getspoiler() ) 
		return "Successfully added car from Repo";
	}
	
	// READ = A method to read from the DB
	public List<CarTB> getAllCars(){
		return this.repo.findAll();
		// SELECT * FROM CAR
	}
	
	// UPDATE
	public CarTB updateCar(Long id, CarTB newCar) {
		
		CarTB oldCar = this.repo.getById(id);
		
		oldCar.setMake(newCar.getMake());
		oldCar.setModel(newCar.getModel());
		oldCar.setEngine(newCar.getEngine());
		oldCar.setSpoiler(newCar.isSpoiler());
		
		// save it back to overwrite the original 
		CarTB updated = this.repo.save(oldCar); 
		return updated;
	}
	
	// DELETE = A method to remove from the DB
	public void removeCar(Long id) {
		this.repo.deleteById(id);
	}
	
    //	Display an entry from the table
	public CarTB retrieveCar(Long id) {
		return this.repo.getById(id);
	}
	
}
