package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Bar;
import com.AJL.travelnest.repository.BarRepository;

@Service
public class BarService {

	@Autowired
	private BarRepository brepo;
	
	public void registar(Bar bar) {
		brepo.save(bar);
	}
	
	public List<Bar> listarB(){
		return brepo.findAll();
	}
	
	
}
