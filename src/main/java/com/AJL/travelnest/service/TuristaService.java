package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Turista;
import com.AJL.travelnest.repository.TuristaRepository;

@Service
public class TuristaService {

	@Autowired
	private TuristaRepository trepo;
	
	public void registrar(Turista turista) {
		trepo.save(turista);
	}
	
	public List<Turista> listarT() {
		return trepo.findAll();
	}
}
