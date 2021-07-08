package com.qa.springcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indicates that it's the main method
@SpringBootApplication
public class SpringCarsApplication {

	public static void main(String[] args) {
		// Create an ApplicationContext - Bean Bag
		SpringApplication.run(SpringCarsApplication.class, args);
		
	}

}
