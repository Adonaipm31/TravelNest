package com.AJL.travelnest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class Restaurante implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String ubicacion;
	@Lob
	private String descripcion;
	private byte calificacion;
	private String sitio_web;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private ListaActividad id_lista;

	public Restaurante(Long id, String nombre, String ubicacion, String descripcion, byte calificacion,
			String sitio_web, ListaActividad id_lista) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.calificacion = calificacion;
		this.sitio_web = sitio_web;
		this.id_lista = id_lista;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(byte calificacion) {
		this.calificacion = calificacion;
	}

	public String getSitio_web() {
		return sitio_web;
	}

	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}

	public ListaActividad getId_lista() {
		return id_lista;
	}

	public void setId_lista(ListaActividad id_lista) {
		this.id_lista = id_lista;
	}
	
	
	
}
