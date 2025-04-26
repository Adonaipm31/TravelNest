package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AJL.travelnest.dto.ServicioDto;
import com.AJL.travelnest.dto.TipoServicio;
import com.AJL.travelnest.service.ServicioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/servicios")
public class ServicioRestController {
	
	private final ServicioService service;

	@Autowired
	public ServicioRestController(ServicioService service) {
		this.service = service;
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<?> obtenerServicio(@RequestParam(required = false)String tipo) {
		
		if (tipo == null || tipo.isBlank()) {
	        return ResponseEntity.ok(service.obtenerTodo());
	    }
		
		try {
	        TipoServicio tipoServicio = TipoServicio.valueOf(tipo.toUpperCase());

	        return switch (tipoServicio) {
			case BAR -> ResponseEntity.ok(service.obtenerBares());
			case HOTEL -> ResponseEntity.ok(service.obtenerHoteles());
			case RESTAURANTE -> ResponseEntity.ok(service.obtenerRestaurante());
	        };      
	    } 
		catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body("Tipo de servicio no válido.");
	    }
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarServicio(@Valid @RequestBody ServicioDto servicioDto) {
		return ResponseEntity.ok(service.registrarServicio(servicioDto));
	}
	
	
		
}
