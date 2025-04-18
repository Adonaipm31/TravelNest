package com.AJL.travelnest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.AJL.travelnest.entity.Servicio;

@Repository
public interface ServicioRepository extends MongoRepository<Servicio, String>{
	
	List<Servicio>findByTipo(String tipo);
	List<Servicio> findByCaracteristicasNombreContainingIgnoreCase(String nombre);
	}
