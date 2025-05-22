package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.AJL.travelnest.entity.Usuario;
import com.AJL.travelnest.service.UsuarioDetails;
import com.AJL.travelnest.service.UsuarioService;

@Controller
@RequestMapping("/panelAdmin")
public class PanelAdminController {
	
	private final UsuarioService service;
		
	@Autowired
	public PanelAdminController(UsuarioService service) {
		super();
		this.service = service;
	}

	@GetMapping({"","/"})
	public String admin(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsuarioDetails usuario = (UsuarioDetails) auth.getPrincipal();

        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("correo", usuario.getCorreo());
		return "panelAdmin";
	}
	
	@GetMapping("/usuarios/listar")
    public String listarEstablecimientos(Model model) {
        model.addAttribute("servicios", service.listar());
        return "usuarios";
    }
	
	@GetMapping("usuarios/eliminar/{correo}")
    public String eliminar(@PathVariable String correo) {
    	service.eliminar(correo);
    	return "redirect:/panelAdmin/usuarios/listar";
    }
	
	@PostMapping("usuarios/{correo}/alternar-rol")
    public String alternarRol(@PathVariable String correo, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuarioActualizado = service.alternarRol(correo);
            redirectAttributes.addFlashAttribute("mensaje", 
                "Rol actualizado a: " + usuarioActualizado.getRol());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", 
                "Usuario no encontrado: " + correo);
        } 

        return "redirect:/panelAdmin/usuarios/listar";
    }
    
}
