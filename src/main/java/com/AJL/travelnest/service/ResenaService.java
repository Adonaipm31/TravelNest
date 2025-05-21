package com.AJL.travelnest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.ResenaDto;
import com.AJL.travelnest.dto.ResenaViewDto;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.entity.Resena;
import com.AJL.travelnest.entity.Usuario;
import com.AJL.travelnest.repository.EstablecimientoRepository;
import com.AJL.travelnest.repository.ResenaRepository;
import com.AJL.travelnest.repository.UsuarioRepository;

@Service
public class ResenaService {

	private final ResenaRepository repo;
    private final EstablecimientoRepository establecimientoRepository;
    private final UsuarioRepository repoUsu;
    
	@Autowired
	public ResenaService(ResenaRepository repo, EstablecimientoRepository establecimientoRepository, UsuarioRepository repoUsu) {
		super();
        this.establecimientoRepository = establecimientoRepository;
		this.repo = repo;
		this.repoUsu = repoUsu;
	}
	
	public Resena registrar(ResenaDto dto) {
		Resena resena = new Resena();
		
        resena.setComentario(dto.getComentario());
        resena.setCalificacion(dto.getCalificacion());
        resena.setEstablecimientoId(dto.getEstablecimientoId());
        resena.setUsuarioId(dto.getUsuarioId());
        resena.setFecha(LocalDate.now());
		
		return repo.save(resena);
	} 
	
	public List<ResenaViewDto> listarConNombreEstablecimiento(String idEstablecimiento) {
	    List<Resena> resenas = repo.findAll();
	    List<ResenaViewDto> resultado = new ArrayList<>();

	    for (Resena resena : resenas) {
	        // Buscar nombre del establecimiento
	        String nombreEst = establecimientoRepository.findById(resena.getEstablecimientoId())
	                .map(e -> e.getCaracteristicas().getNombre())
	                .orElse("Establecimiento no encontrado");

	        // Buscar nombre del usuario
	        String nombreUser = repoUsu.findById(resena.getUsuarioId())
	                .map(Usuario::getNombre)
	                .orElse("Usuario no encontrado");

	        // Solo agregar si el establecimiento coincide con el filtro (idEstablecimiento)
	        if (resena.getEstablecimientoId().equals(idEstablecimiento)) {
	            ResenaViewDto dto = new ResenaViewDto();
	            dto.setComentario(resena.getComentario());
	            dto.setCalificacion(resena.getCalificacion());
	            dto.setFecha(resena.getFecha().toString());
	            dto.setUsuario(nombreUser); 
	            dto.setEstablecimientoNombre(nombreEst);
	            resultado.add(dto);
	        }
	    }

	    return resultado;
	}

	public List<ResenaViewDto> listarTodo() {
	    List<Resena> resenas = repo.findAll();
	    List<ResenaViewDto> resultado = new ArrayList<>();

	    for (Resena resena : resenas) {
	        // Verificamos que los IDs no sean null
	        if (resena.getEstablecimientoId() == null || resena.getUsuarioId() == null) {
	            continue; // Saltar reseña inválida
	        }

	        // Buscar nombre del establecimiento
	        String nombreEst = establecimientoRepository.findById(resena.getEstablecimientoId())
	                .map(e -> e.getCaracteristicas().getNombre())
	                .orElse("Establecimiento no encontrado");

	        // Buscar nombre del usuario
	        String nombreUser = repoUsu.findById(resena.getUsuarioId())
	                .map(Usuario::getNombre)
	                .orElse("Usuario no encontrado");

	        ResenaViewDto dto = new ResenaViewDto();
	        dto.setComentario(resena.getComentario());
	        dto.setCalificacion(resena.getCalificacion());
	        dto.setFecha(resena.getFecha().toString());
	        dto.setUsuario(nombreUser); 
	        dto.setEstablecimientoNombre(nombreEst);
	        resultado.add(dto);
	    }

	    return resultado;
	}

}
