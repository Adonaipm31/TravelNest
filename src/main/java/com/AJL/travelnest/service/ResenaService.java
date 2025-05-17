package com.AJL.travelnest.service;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.ResenaDto;
import com.AJL.travelnest.entity.Resena;
import com.AJL.travelnest.repository.ResenaRepository;

@Service
public class ResenaService {

	private final ResenaRepository repo;

	@Autowired
	public ResenaService(ResenaRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Resena registrar(ResenaDto dto) {
		Resena resena = new Resena();
		
        resena.setComentario(dto.getComentario());
        resena.setCalificacion(dto.getCalificacion());
        resena.setEstablecimientoId(new ObjectId(dto.getEstablecimientoId()));
        resena.setFecha(LocalDate.now());
		
		return repo.save(resena);
	} 
	
	
}
