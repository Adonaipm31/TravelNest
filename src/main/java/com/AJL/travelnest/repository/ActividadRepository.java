package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
