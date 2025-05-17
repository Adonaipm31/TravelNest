package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.AJL.travelnest.service.EstablecimientoService;

@Controller
public class publicControllers {
	
    private final EstablecimientoService service;

    @Autowired
	public publicControllers(EstablecimientoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/login")
	private String login() {
		return "login";
	}
	
	@GetMapping("/restaurant")
	private String restaurant(Model model) {
		model.addAttribute("servicios", service.obtenerRestaurante());
		return "Restaurants";
	}
	
	@GetMapping("/hotel")
    public String hotel(Model model) {
        model.addAttribute("servicios", service.obtenerHoteles());
        return "hotels";
    }

	@GetMapping("/bars")
	private String bars(Model model) {
		model.addAttribute("servicios", service.obtenerBares());
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
	
	@GetMapping({" ","/","/home"})
	private String home() {
		return "index.html";
	}
}
