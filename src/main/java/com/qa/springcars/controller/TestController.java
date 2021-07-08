package com.qa.springcars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Allows for external access to our application via HTTPRequests
@RestController
public class TestController {
	
	// Allows our program to accept REQUESTS and send RESPONSES 
	
	// EndPoint for test
	@GetMapping("/test") // @TypeOfRequest("location")
	public String thisMethod() {
		return "Hi";
	}

}
