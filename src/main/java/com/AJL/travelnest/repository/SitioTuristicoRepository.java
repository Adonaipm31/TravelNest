package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.SitiosTuristicos;

@Repository
public interface SitioTuristicoRepository extends JpaRepository<SitiosTuristicos, Long> {

}
