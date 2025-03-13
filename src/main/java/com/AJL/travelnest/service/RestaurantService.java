package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Restaurante;
import com.AJL.travelnest.repository.RestauranteRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestauranteRepository restrepo;
	
	public void registar(Restaurante restaurante) {
		restrepo.save(restaurante);
	}
	
	public List<Restaurante> listarR(){
		return restrepo.findAll();
	}

}
