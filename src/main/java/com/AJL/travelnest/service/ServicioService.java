package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.ServicioDto;
import com.AJL.travelnest.entity.Servicio;
import com.AJL.travelnest.repository.ServicioRepository;

@Service
public class ServicioService {
	 private final ServicioRepository servicioRepository;

	    @Autowired
	    public ServicioService(ServicioRepository servicioRepository) {
	        this.servicioRepository = servicioRepository;
	    }

	    public List<Servicio> obtenerHoteles() {
	        return servicioRepository.findByTipo("HOTEL");
	    }

	    
}
