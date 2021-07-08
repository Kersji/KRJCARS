package com.qa.springcars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Marking the Class as a Table
public class CarTB {
	
	@Id // Define a Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY )
							   // Auto-Increment 
	private Long id;
	
	// Variables

	private String make;
	private String model;
	private int engine;
	private boolean spoiler;

	// Methods
	
	// Constructor with all parameters
	public CarTB(String make, String model, 
			int engine, boolean spoiler) {
		this.make = make;
		this.model = model;
		this.engine = engine;
		this.spoiler = spoiler;
	}
	
	// Default constructor
	public CarTB() {}
	
	// Getters and Setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public boolean isSpoiler() {
		return spoiler;
	}

	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}

}
