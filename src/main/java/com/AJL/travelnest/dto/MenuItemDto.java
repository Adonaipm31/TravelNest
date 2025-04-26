package com.AJL.travelnest.dto;

import jakarta.validation.constraints.NotBlank;

public class MenuItemDto {

	@NotBlank
	private String nombrePlato;
	
    private String descripcion;
	@NotBlank
	private double precio;
	@NotBlank
	private String categoria;
	
	public MenuItemDto() {
		super();
	}
	public MenuItemDto(@NotBlank String nombrePlato, String descripcion, @NotBlank double precio,
			@NotBlank String categoria) {
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
