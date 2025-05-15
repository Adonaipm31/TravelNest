package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    
    public List<Usuario> listar(){
    	return usuarioRepository.findAll();
    }
}
