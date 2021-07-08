package com.qa.springcars.domain;

public class Car {

	// Variables

	private String make;
	private String model;
	private int engine;
	private boolean spoiler;

	// Methods
	
	// Constructor with all parameters
	public Car(String make, String model, 
			int engine, boolean spoiler) {
		this.make = make;
		this.model = model;
		this.engine = engine;
		this.spoiler = spoiler;
	}
	
	// Default constructor
	public Car() {}
	
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
