package com.AJL.travelnest.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsuarioDetails extends User {

    private String nombre;
    private String apellido;
    private String correo;
    private String pais;

    public UsuarioDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, 
                          String nombre, String apellido, String correo, String pais) {
        super(username, password, authorities);
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pais = pais;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPais() {
        return pais;
    }

    
}

