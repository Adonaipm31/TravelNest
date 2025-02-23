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
	private long id;
	
	public long id() {
		return id;
	}
}
