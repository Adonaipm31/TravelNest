package com.AJL.travelnest.entity;

public class Direccion {
	
    private String calle;
    private String numero;
    private String barrio;
    
	public Direccion(String calle, String numero, String barrio) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
	}

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

