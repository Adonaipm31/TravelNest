package com.AJL.travelnest.dto;

public class ResenaDto {
    private String comentario;
    private int calificacion;
    private String establecimientoId;  
    private String usuarioId;
    
	public ResenaDto() {
		super();
	}

	public ResenaDto(String comentario, int calificacion, String establecimientoId, String usuarioId) {
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.establecimientoId = establecimientoId;
		this.usuarioId = usuarioId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstablecimientoId() {
		return establecimientoId;
	}

	public void setEstablecimientoId(String establecimientoId) {
		this.establecimientoId = establecimientoId;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}		
}
