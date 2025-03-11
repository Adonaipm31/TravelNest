package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.ListaActividad;

@Repository
public interface ListaActividadRepository extends JpaRepository<ListaActividad, Long> {

}
