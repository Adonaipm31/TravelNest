package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.AJL.travelnest.service.UsuarioService;

@Controller
public class PanelAdminController {
	
	private final UsuarioService service;
		
	@Autowired
	public PanelAdminController(UsuarioService service) {
		super();
		this.service = service;
	}

	@GetMapping("panelAdmin")
	public String admin() {
		return "panelAdmin";
	}
	
	@GetMapping("/usuarios/listar")
    public String listarEstablecimientos(Model model) {
        model.addAttribute("servicios", service.listar());
        return "usuarios";
    }
}
