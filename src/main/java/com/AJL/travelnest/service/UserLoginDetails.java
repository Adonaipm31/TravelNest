package com.AJL.travelnest.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.AJL.travelnest.entity.Usuario;
import com.AJL.travelnest.repository.UsuarioRepository;

@Service
public class UserLoginDetails implements UserDetailsService{
	
	private final UsuarioRepository repo;
	
	@Autowired
	public UserLoginDetails(UsuarioRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    return repo.findByCorreo(email)
	            .map(usuario -> User.withUsername(usuario.getCorreo())
	                                .password(usuario.getPassword())
	                                .roles(usuario.getRol())
	                                .build())
	            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + email));
	}


}
