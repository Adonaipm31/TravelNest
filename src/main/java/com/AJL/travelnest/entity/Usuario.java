package com.AJL.travelnest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Usuario implements Serializable{
	
	private String nombre_compl;
	private int edad;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Usuario(String nombre_compl, int edad, String password, Long id) {
		super();
		this.nombre_compl = nombre_compl;
		this.edad = edad;
		this.password = password;
		this.id = id;
	}

	public String getNombre_compl() {
		return nombre_compl;
	}

	public void setNombre_compl(String nombre_compl) {
		this.nombre_compl = nombre_compl;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
