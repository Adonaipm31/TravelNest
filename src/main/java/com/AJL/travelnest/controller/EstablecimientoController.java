package com.AJL.travelnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.AJL.travelnest.dto.EstablecimientoDto;
import com.AJL.travelnest.dto.TipoServicio;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.service.EstablecimientoService;
import java.util.List;

@Controller
@RequestMapping("/establecimientos")
public class EstablecimientoController {

    private final EstablecimientoService service;
    
    @Autowired
    public EstablecimientoController(EstablecimientoService establecimientoService) {
        this.service = establecimientoService;
    }
    
    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("servicioDto", new EstablecimientoDto());
        model.addAttribute("tiposServicio", TipoServicio.values()); // Agrega esto
        model.addAttribute("servicios", service.listar());
        return "establecimientoRegister";
    }
    @PostMapping("/registrar")
    public String registrarEstablecimiento(
            @ModelAttribute("servicioDto") EstablecimientoDto establecimientoDto,
            @RequestParam(name = "tipoCocinaRaw", required = false) String tipoCocinaRaw,
            Model model
    ) {
        if (establecimientoDto.getTipo() == TipoServicio.RESTAURANTE && tipoCocinaRaw != null) {
            List<String> tipos = List.of(tipoCocinaRaw.split(",\\s*"));
            establecimientoDto.setTipoCosina(tipos);
        }

        // Guardar el establecimiento
        service.registrarServicio(establecimientoDto);

        return "redirect:/establecimientos/listar"; 
    }
    
    @GetMapping("/filtrar")
    public String filtrarPorTipo(@RequestParam("tipo") TipoServicio tipo, Model model) {
        List<Establecimiento> resultados;  
        switch (tipo) {
        case RESTAURANTE:
            resultados = service.obtenerRestaurante();
            break;
        case BAR:
            resultados = service.obtenerBares();
            break;
        case HOTEL:
            resultados = service.obtenerHoteles();
            break;
        case ROOFTOP:
            resultados = service.obtenerHoteles();
            break;
        default:
            throw new IllegalArgumentException("Tipo de servicio no reconocido: " + tipo);
    }
    	 
    	model.addAttribute("service", resultados);
    	model.addAttribute("tiposServicio", TipoServicio.values()); 
    	model.addAttribute("establecimientoDto", new EstablecimientoDto()); // Para mantener el formulario vacío

    	return "redirect:/establecimientos";    
    	
    }
    
    @GetMapping("/listar")
    public String listarEstablecimientos(Model model) {
        model.addAttribute("servicios", service.listar());
        return "establecimientos";
    }

}
