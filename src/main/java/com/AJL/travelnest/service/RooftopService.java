package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Rooftop;
import com.AJL.travelnest.repository.RooftopRepository;

@Service
public class RooftopService {

	@Autowired
	private RooftopRepository rorepo;
	
	public void registrar(Rooftop roo) {
		rorepo.save(roo);
	}
	
	public List<Rooftop> listarR() {
		return rorepo.findAll();
	}
}
