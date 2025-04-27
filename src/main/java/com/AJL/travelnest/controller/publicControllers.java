package com.AJL.travelnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class publicControllers {

	@GetMapping("/login")
	private String login() {
		return "login";
	}
	
	@GetMapping("/restaurant")
	private String restaurant() {
		return "Restaurants";
	}
	
	@GetMapping("/hotel")
	private String hotel() {
		return "hotels";
	}

	@GetMapping("/bars")
	private String bars() {
		return "bars";
	}
	@GetMapping("/rooftop")
	private String rooftop() {
		return "rooftop";
	}
	
	@GetMapping("/contact")
	private String contact() {
		return "contact";
	}
}
