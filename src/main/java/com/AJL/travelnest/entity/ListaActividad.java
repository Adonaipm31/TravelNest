package com.AJL.travelnest.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ListaActividad implements Serializable{

	@Id
	private Long id;
	private LocalDate Fecha_creacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Turista id_turista;

	public ListaActividad(Long id, LocalDate fecha_creacion, Turista id_turista) {
		super();
		this.id = id;
		Fecha_creacion = fecha_creacion;
		this.id_turista = id_turista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha_creacion() {
		return Fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		Fecha_creacion = fecha_creacion;
	}

	public Turista getId_turista() {
		return id_turista;
	}

	public void setId_turista(Turista id_turista) {
		this.id_turista = id_turista;
	}
	
	
}
