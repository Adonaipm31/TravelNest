package com.AJL.travelnest.dto;

import jakarta.validation.constraints.NotBlank;

public class HorarioDTO {
	@NotBlank
	private String dia;

	@NotBlank
	private String horaApertura;

	@NotBlank
	private String horaCierre;	
	

	public HorarioDTO() {
		super();
	}

	public HorarioDTO(@NotBlank String dia, @NotBlank String horaApertura, @NotBlank String horaCierre) {
		super();
		this.dia = dia;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}
	
	
}
