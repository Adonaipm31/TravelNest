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
	private String nombre;
	private LocalDate fecha_creacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Turista id_turista;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Restaurante id_restaurante;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Hotel id_hotel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Rooftop id_rooftop;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Bar id_bar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SitiosTuristicos id_sitioT;

	public ListaActividad(Long id, String nombre, LocalDate fecha_creacion, Turista id_turista, Restaurante id_restaurante,
			Hotel id_hotel, Rooftop id_rooftop, Bar id_bar, SitiosTuristicos id_sitioT) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.id_turista = id_turista;
		this.id_restaurante = id_restaurante;
		this.id_hotel = id_hotel;
		this.id_rooftop = id_rooftop;
		this.id_bar = id_bar;
		this.id_sitioT = id_sitioT;
	}
	
	
	
	
}
