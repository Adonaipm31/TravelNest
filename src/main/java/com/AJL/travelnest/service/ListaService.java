package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.ListaActividad;
import com.AJL.travelnest.repository.ListaActividadRepository;

@Service
public class ListaService {

	@Autowired
	private ListaActividadRepository lrepo;
	
	public void registrar(ListaActividad lista) {
		lrepo.save(lista);
	}
	
	public List<ListaActividad> listar() {
		return lrepo.findAll();
	}
}
