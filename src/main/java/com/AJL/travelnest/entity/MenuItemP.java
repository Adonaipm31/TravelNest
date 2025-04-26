package com.AJL.travelnest.entity;

public class MenuItemP {
    private String nombrePlato;
    private String descripcion;
    private double precio;
    private String categoria;
    
	public MenuItemP() {
		super();
	}

	public MenuItemP(String nombrePlato, String descripcion, double precio, String categoria) {
		super();
		this.nombrePlato = nombrePlato;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
}
