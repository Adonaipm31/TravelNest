package com.AJL.travelnest.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
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
            .map(usuario -> new UsuarioDetails(
                    usuario.getCorreo(), 
                    usuario.getPassword(), 
                    List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getCorreo(),
                    usuario.getPais()
            ))
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + email));
    }

	public Usuario obtenerPorCorreo(String correo) {
        return repo.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
