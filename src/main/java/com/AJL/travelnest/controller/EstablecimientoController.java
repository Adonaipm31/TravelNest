package com.AJL.travelnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.AJL.travelnest.dto.EstablecimientoDto;
import com.AJL.travelnest.dto.TipoServicio;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.service.EstablecimientoService;


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
        model.addAttribute("tiposServicio", TipoServicio.values()); 
        model.addAttribute("servicios", service.listar());
        List<String> barrios = List.of("Bocagrande", "Getsemani", "Laguito", "Centro", "Castillogrande");
        model.addAttribute("barriosDisponibles", barrios);
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
        service.registrarServicio(establecimientoDto);
        return "redirect:/establecimientos/listar";
    }

    @GetMapping("/listar")
    public String listarEstablecimientos(Model model) {
        model.addAttribute("servicios", service.listar());
        return "establecimientos";
    }
        
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable String id, Model model) {
        Establecimiento entidad = service.obtenerPorId(id);
        EstablecimientoDto dto = service.mapearEntidadADTO(entidad);

        model.addAttribute("servicioDto", dto);
        model.addAttribute("id", id); 
        return "establecimientoActualizar"; 
    }
    
    @PostMapping("/actualizar/{id}")
    public String procesarActualizacion(@PathVariable String id,
                                        @ModelAttribute("servicioDto") EstablecimientoDto establecimientoDto) {
        service.actualizar(id, establecimientoDto);
        return "redirect:/establecimientos/listar?actualizado";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
    	service.eliminar(id);
    	return "redirect:/establecimientos/listar?eliminado";
    }
}

 