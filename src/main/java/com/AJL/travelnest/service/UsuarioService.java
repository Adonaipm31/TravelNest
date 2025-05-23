package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.EstablecimientoDto;
import com.AJL.travelnest.dto.UsuarioDto;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.entity.Usuario;
import com.AJL.travelnest.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarUsuario(UsuarioDto dto) {
    	try {
			Usuario usuario = new Usuario();
			usuario.setNombre(dto.getNombre());
			usuario.setApellido(dto.getApellido());
			usuario.setCorreo(dto.getCorreo());
			usuario.setRol("USER");

			// Encriptar la contraseña
			usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
			usuario.setPais(dto.getPais());

			if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
				throw new IllegalArgumentException("El correo ya está registrado");
			}

			return usuarioRepository.save(usuario);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}

		return null;
    }
    
    public boolean existeUsuarioCorreo(String correo) {
		return usuarioRepository.findByCorreo(correo).isPresent();
	}
    
    @Cacheable(value = "usuarios")
    public List<Usuario> listar(){
    	return usuarioRepository.findAll();
    }
    @Cacheable(value = "usuarios", key = "#correo")
    public Usuario obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    
    @CacheEvict(value = "usuarios", key = "#correo")
	public void eliminar(String correo) {
		Usuario user = obtenerPorCorreo(correo);
		
		usuarioRepository.delete(user);
		
	}
	
	public Usuario alternarRol(String correo) {
	    Usuario usuario = usuarioRepository.findByCorreo(correo)
	        .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con correo: " + correo)); 

	    String rolActual = usuario.getRol();
	    
	    if ("USER".equalsIgnoreCase(rolActual)) {
	        usuario.setRol("ADMIN");
	    } else if ("ADMIN".equalsIgnoreCase(rolActual)) {
	        usuario.setRol("USER");
	    } else {
	        throw new IllegalArgumentException("Rol desconocido: " + rolActual);
	    }

	    return usuarioRepository.save(usuario);
	}


}
