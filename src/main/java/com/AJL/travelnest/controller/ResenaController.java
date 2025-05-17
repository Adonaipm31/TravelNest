package com.AJL.travelnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AJL.travelnest.dto.ResenaDto;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.service.EstablecimientoService;
import com.AJL.travelnest.service.ResenaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/resena")
public class ResenaController {

	private final ResenaService service;
	private final EstablecimientoService estaService;

	@Autowired
	public ResenaController(ResenaService service, EstablecimientoService estaService) {
		super();
		this.service = service;
		this.estaService = estaService;
	}
	@GetMapping("/registrar")
    public String mostrarFormulario(@RequestParam("name") String nombre, Model model) {
		List<Establecimiento> esta =  estaService.buscarPorNombre(nombre);

		Establecimiento ids = esta.get(0);
		
	    ResenaDto resenaDto = new ResenaDto();
	    resenaDto.setEstablecimientoId(ids.getId());
	    
        model.addAttribute("resenaDto", resenaDto);
        model.addAttribute("nombreEstablecimiento", nombre);
        return "resena";
	}
	@PostMapping("/registrar")
	public String registar(@ModelAttribute("resenaDto") @Valid ResenaDto dto, BindingResult result, Model model) {
		service.registrar(dto);
		return "redirect:/home";
	}
	
	
}
