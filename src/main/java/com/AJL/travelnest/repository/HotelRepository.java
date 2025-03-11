package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	
}
