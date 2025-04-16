package com.AJL.travelnest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CaracteristicaServicio {
    private String nombre;
    private Direccion direccion;
    private double precioPromedio;
    private double calificacion;
    
	public CaracteristicaServicio(String nombre, Direccion direccion, double precioPromedio, double calificacion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioPromedio = precioPromedio;
		this.calificacion = calificacion;
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
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
    
    
}

