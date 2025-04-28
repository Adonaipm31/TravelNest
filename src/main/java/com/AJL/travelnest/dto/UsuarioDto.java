package com.AJL.travelnest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {

    @NotBlank(message = "El nombre es obligatorio")
    String nombre;
    String apellido;
    
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    String correo;
    
    @NotBlank(message = "la contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    String password;
    
    String rol = "USER";
    String pais;
    
	public UsuarioDto() {
		super();
	}
	public UsuarioDto(@NotBlank(message = "El nombre es obligatorio") String nombre, String apellido,
			@NotBlank(message = "El email es obligatorio") String correo,
			@NotBlank(message = "la contraseña es obligatoria") String password, String rol, String pais) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

}
