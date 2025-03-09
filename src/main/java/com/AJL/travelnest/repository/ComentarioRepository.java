package com.AJL.travelnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
