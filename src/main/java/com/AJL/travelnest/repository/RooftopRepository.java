package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Rooftop;

@Repository
public interface RooftopRepository extends JpaRepository<Rooftop, Long> {

}
