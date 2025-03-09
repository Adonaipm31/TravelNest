package com.AJL.travelnest.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Usuario implements Serializable {
	
	private LocalDate fecha_ingreso;

	public Admin(String nombre_compl, int edad, String password, Long id, LocalDate fecha_ingreso) {
		super(nombre_compl, edad, password, id);
		this.fecha_ingreso = fecha_ingreso;
	}

	public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDate fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	

}
