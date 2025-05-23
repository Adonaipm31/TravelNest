package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.AJL.travelnest.dto.UsuarioDto;
import com.AJL.travelnest.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	private final UsuarioService usuarioService;

	@Autowired
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/signup")
    public String mostrarFormularioRegistro(Model model) {
    	UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute(usuarioDto);
        return "signup";
    }

    @PostMapping("/signup")
    public String registrarUsuario(@ModelAttribute("usuarioDto") @Valid UsuarioDto dto,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            return "signup";
        }

        // Validación si ya existe un usuario con ese correo
        if (usuarioService.existeUsuarioCorreo(dto.getCorreo())) {
            model.addAttribute("errorCorreo", "Ya existe un usuario con ese correo");
            return "signup";
        }

        usuarioService.registrarUsuario(dto);
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "redirect:/login";
    }
	
}
