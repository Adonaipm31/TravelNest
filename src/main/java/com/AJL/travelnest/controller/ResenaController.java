package com.AJL.travelnest.controller;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AJL.travelnest.dto.ResenaDto;
import com.AJL.travelnest.dto.ResenaViewDto;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.entity.Usuario;
import com.AJL.travelnest.repository.EstablecimientoRepository;
import com.AJL.travelnest.service.EstablecimientoService;
import com.AJL.travelnest.service.ResenaService;
import com.AJL.travelnest.service.UsuarioDetails;
import com.AJL.travelnest.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/resena")
public class ResenaController {

	private final ResenaService service;
	private final EstablecimientoService estaService;
	private final UsuarioService usuServi;
	
	@Autowired
	public ResenaController(ResenaService service, EstablecimientoService estaService, UsuarioService usuServi) {
		super();
		this.service = service;
		this.estaService = estaService;
		this.usuServi = usuServi;
	}
	
	@GetMapping("/registrar")
	public String mostrarFormulario(@RequestParam("id") String idEstablecimiento, Model model) {
	    ResenaDto resenaDto = new ResenaDto();
	    resenaDto.setEstablecimientoId(idEstablecimiento);
	    model.addAttribute("resenaDto", resenaDto);
	    return "resena";
	}

	@PostMapping("/registrar")
	public String registrarResena(@ModelAttribute("resenaDto") @Valid ResenaDto resenaDto, BindingResult result) {
	    if (result.hasErrors()) {
	        return "resena";
	    }

	    // Obtener usuario autenticado
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
	    
	    Usuario usuario = usuServi.obtenerPorCorreo(userDetails.getUsername());
	    
	    // Asignar id usuario al DTO justo antes de guardar
	    resenaDto.setUsuarioId(usuario.getId());

	    service.registrar(resenaDto);
	    return "redirect:/resena/listar";
	}

	
	@GetMapping("/listar")
    public String listarTodas(Model model) {
        List<ResenaViewDto> resenas = service.listarTodo();
        model.addAttribute("resenas", resenas);
        return "resenaList"; 
    }
	
	@GetMapping("/listarN/{id}")
    public String listarPorEstablecimiento(@PathVariable("id") String idEstablecimiento, Model model) {
        List<ResenaViewDto> resenas = service.listarConNombreEstablecimiento(idEstablecimiento);
        model.addAttribute("resenas", resenas);
        return "resenaList"; 
    }
	
}
