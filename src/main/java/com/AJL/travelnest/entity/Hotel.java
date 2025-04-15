package com.AJL.travelnest.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "hoteles")
public class Hotel {
    @Id
    private String id;

    private String nombre;

    private Direccion direccion;

    private double precioPromedio;

    private int numeroHabitaciones;

    private double calificacion;

	public Hotel(String id, String nombre, Direccion direccion, double precioPromedio, int numeroHabitaciones,
			double calificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioPromedio = precioPromedio;
		this.numeroHabitaciones = numeroHabitaciones;
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

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
    
}
