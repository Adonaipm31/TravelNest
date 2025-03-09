package com.AJL.travelnest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Turista extends Usuario implements Serializable{

	private String email;

	public Turista(String nombre_compl, int edad, String password, Long id, String email) {
		super(nombre_compl, edad, password, id);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
