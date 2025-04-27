package com.AJL.travelnest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	List<Usuario> findByNombre(String nombre);
	Optional<Usuario> findByCorreo(String correo);
	
}
