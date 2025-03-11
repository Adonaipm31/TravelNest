package com.AJL.travelnest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class SitiosTuristicos implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String ubicacion;
	@Lob
	private String descripcion;
	private String url_image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ListaActividad id_lista;

	public SitiosTuristicos(Long id, String nombre, String ubicacion, String descripcion, String url_image,
			ListaActividad id_lista) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.url_image = url_image;
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

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public ListaActividad getId_lista() {
		return id_lista;
	}

	public void setId_lista(ListaActividad id_lista) {
		this.id_lista = id_lista;
	}

	
	
}
