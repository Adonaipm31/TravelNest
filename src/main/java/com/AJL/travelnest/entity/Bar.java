package com.AJL.travelnest.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "bares")
public class Bar {
    @Id
    private String id;

    private String nombre;
    private Direccion direccion;
    private double precioPromedio;
    private List<HorarioAtencion> horarioAtencion;
    private String tipo;
    private String tipoMusica; 
    private double calificacion;
	public Bar(String id, String nombre, Direccion direccion, double precioPromedio,
			List<HorarioAtencion> horarioAtencion, String tipo, String tipoMusica, double calificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioPromedio = precioPromedio;
		this.horarioAtencion = horarioAtencion;
		this.tipo = tipo;
		this.tipoMusica = tipoMusica;
		this.calificacion = calificacion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public double getPrecioPromedio() {
		return precioPromedio;
	}
	public void setPrecioPromedio(double precioPromedio) {
		this.precioPromedio = precioPromedio;
	}
	public List<HorarioAtencion> getHorarioAtencion() {
		return horarioAtencion;
	}
	public void setHorarioAtencion(List<HorarioAtencion> horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoMusica() {
		return tipoMusica;
	}
	public void setTipoMusica(String tipoMusica) {
		this.tipoMusica = tipoMusica;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
    
    
}

