package com.AJL.travelnest.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "restaurantes")
public class Restaurante {
    @Id
    private String id;

    private String nombre;
    private Direccion direccion;
    private double precioPromedio;
    private List<MenuItem> menuPrincipal;
    private double calificacion;
    
	public Restaurante(String id, String nombre, Direccion direccion, double precioPromedio,
			List<MenuItem> menuPrincipal, double calificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioPromedio = precioPromedio;
		this.menuPrincipal = menuPrincipal;
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
	public List<MenuItem> getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(List<MenuItem> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
    
    
    
}
