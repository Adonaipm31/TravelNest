package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.SitiosTuristicos;
import com.AJL.travelnest.repository.SitioTuristicoRepository;

@Service
public class SitioService {

	@Autowired
	private SitioTuristicoRepository strepo;
	
	public void registar(SitiosTuristicos sitio) {
		strepo.save(sitio);
	}
	
	public List<SitiosTuristicos> listarS() {
		return strepo.findAll();
	}
}
