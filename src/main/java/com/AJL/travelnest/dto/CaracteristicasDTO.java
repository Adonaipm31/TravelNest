package com.AJL.travelnest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CaracteristicasDTO {
	
    private String nombre;
    @NotNull
    private DireccionDto direccion;
    @NotBlank
    private String image;
    private String telefono; 
    private double precioPromedio;
    @NotBlank
    private double calificacion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DireccionDto getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionDto direccion) {
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
