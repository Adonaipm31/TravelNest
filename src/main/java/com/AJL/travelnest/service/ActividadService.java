package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Actividad;
import com.AJL.travelnest.repository.ActividadRepository;

@Service
public class ActividadService {

	@Autowired
	private ActividadRepository lrepo;
	
	public void registrar(Actividad lista) {
		lrepo.save(lista);
	}
	
	public List<Actividad> listar() {
		return lrepo.findAll();
	}
}
