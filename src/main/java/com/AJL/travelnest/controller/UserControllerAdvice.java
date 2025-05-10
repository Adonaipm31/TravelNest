package com.AJL.travelnest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.AJL.travelnest.service.UsuarioDetails;

@ControllerAdvice
public class UserControllerAdvice {
	
	@ModelAttribute
    public void agregarDatosUsuario(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            UsuarioDetails usuario = (UsuarioDetails) auth.getPrincipal();
            model.addAttribute("usuarioLogueado", usuario);
        }
    }
}