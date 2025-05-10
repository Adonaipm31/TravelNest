package com.AJL.travelnest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.dto.TipoServicio;


@Repository
public interface EstablecimientoRepository extends MongoRepository<Establecimiento, String>{
	
	List<Establecimiento>findByTipo(TipoServicio tipo);
	List<Establecimiento> findByCaracteristicasNombreContainingIgnoreCase(String nombre);
	}
