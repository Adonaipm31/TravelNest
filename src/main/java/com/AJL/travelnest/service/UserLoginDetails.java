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
		Optional<Usuario> usuarioVerifi = repo.findByCorreo(email);
		
		if (usuarioVerifi.isPresent()) {
			Usuario usuarioResponse = usuarioVerifi.get(); 
			
			var springUser = User.withUsername(usuarioResponse.getNombre())
				.password(usuarioResponse.getPassword())
				.roles(usuarioResponse.getRol())
				.build();
			
			return springUser;
		}
		return null;
	}

}
