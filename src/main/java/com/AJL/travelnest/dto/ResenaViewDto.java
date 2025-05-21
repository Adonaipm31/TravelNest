package com.AJL.travelnest.dto;

public class ResenaViewDto {
    private String comentario;
    private double calificacion;
    private String fecha;
    private String establecimientoNombre;
    private String usuario;
    	
	public ResenaViewDto(String comentario, double calificacion, String fecha, String establecimientoNombre,
			String usuario) {
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.fecha = fecha;
		this.establecimientoNombre = establecimientoNombre;
		this.usuario = usuario;
	}
	
	public ResenaViewDto() {
		super();
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstablecimientoNombre() {
		return establecimientoNombre;
	}

	public void setEstablecimientoNombre(String establecimientoNombre) {
		this.establecimientoNombre = establecimientoNombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}

