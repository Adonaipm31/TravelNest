package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Turista;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Long> {

}
