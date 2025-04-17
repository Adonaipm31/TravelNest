package com.AJL.travelnest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class HorarioAtencion {
    private String dia;
    private String apertura;
    private String cierre;
    
	public HorarioAtencion(String dia, String apertura, String cierre) {
		super();
		this.dia = dia;
		this.apertura = apertura;
		this.cierre = cierre;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getApertura() {
		return apertura;
	}
	public void setApertura(String apertura) {
		this.apertura = apertura;
	}
	public String getCierre() {
		return cierre;
	}
	public void setCierre(String cierre) {
		this.cierre = cierre;
	}
}
