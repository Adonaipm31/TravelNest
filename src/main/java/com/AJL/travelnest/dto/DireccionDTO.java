package com.AJL.travelnest.dto;

import jakarta.validation.constraints.NotBlank;

public class DireccionDTO {
	@NotBlank
	private String calle;
    @NotBlank
	private String numero;
	@NotBlank
	private String barrio;
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	
}
