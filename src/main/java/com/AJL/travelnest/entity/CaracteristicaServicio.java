package com.AJL.travelnest.entity;

import com.AJL.travelnest.dto.DireccionDTO;

public class CaracteristicaServicio {
    private String nombre;
    private DireccionDTO direccion;
    private String image;
    private String telefono; 
    private double precioPromedio;
    private double calificacion;
    
	public CaracteristicaServicio() {
		super();
	}

	public CaracteristicaServicio(String nombre, DireccionDTO direccion, String image, String telefono,
			double precioPromedio, double calificacion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.image = image;
		this.telefono = telefono;
		this.precioPromedio = precioPromedio;
		this.calificacion = calificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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