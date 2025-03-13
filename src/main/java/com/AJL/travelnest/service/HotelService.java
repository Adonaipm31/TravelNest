package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Hotel;
import com.AJL.travelnest.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hrepo;
	
	public void registar(Hotel hotel) {
		hrepo.save(hotel);
	}
	
	public List<Hotel> listarH(){
		return hrepo.findAll();
	}
	
	

}
