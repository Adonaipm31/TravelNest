package com.AJL.travelnest.entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "resenas")
public class Resena {
    @Id
    private String id;

    private String comentario;
    private int calificacion;

    @Field("establecimiento_id")
    private String establecimientoId; 
    
    @Field("usuario_id")
    private String usuarioId;

    private LocalDate fecha;

	public Resena(String id, String comentario, int calificacion, String establecimientoId, String usuarioId,
			LocalDate fecha) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.establecimientoId = establecimientoId;
		this.usuarioId = usuarioId;
		this.fecha = fecha;
	}

	public Resena() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}

