package com.AJL.travelnest.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Actividad implements Serializable{

	@Id
	private Long id;
	private String nombre;
	private LocalDate fecha_creacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Turista turista;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurante restaurante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rooftop rooftop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Bar bar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SitiosTuristicos sitioT;

	public Actividad(Long id, String nombre, LocalDate fecha_creacion, Turista turista, Restaurante restaurante,
			Hotel hotel, Rooftop rooftop, Bar bar, SitiosTuristicos sitioT) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.turista = turista;
		this.restaurante = restaurante;
		this.hotel = hotel;
		this.rooftop = rooftop;
		this.bar = bar;
		this.sitioT = sitioT;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Rooftop getRooftop() {
		return rooftop;
	}

	public void setRooftop(Rooftop rooftop) {
		this.rooftop = rooftop;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public SitiosTuristicos getSitioT() {
		return sitioT;
	}

	public void setSitioT(SitiosTuristicos sitioT) {
		this.sitioT = sitioT;
	}	
	
}
