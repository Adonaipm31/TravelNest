package com.AJL.travelnest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedireccionController {

    @GetMapping("/redireccion")
    public String redireccionPorRol() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:/panelAdmin";
                }
            }
            // Rol distinto de ADMIN (por ejemplo, USER, CLIENTE, etc.)
            return "redirect:/"; // o "redirect:/panelUsuario"
        }

        return "redirect:/login?error";
    }
}
