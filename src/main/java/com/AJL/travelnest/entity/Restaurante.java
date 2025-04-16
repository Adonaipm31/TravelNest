package com.AJL.travelnest.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "restaurantes")
public class Restaurante {
    @Id
    private String id;
    private CaracteristicaServicio servicio;
    private List<MenuItem> menuPrincipal;
    
	public Restaurante(String id, CaracteristicaServicio servicio, List<MenuItem> menuPrincipal) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.menuPrincipal = menuPrincipal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CaracteristicaServicio getServicio() {
		return servicio;
	}
	public void setServicio(CaracteristicaServicio servicio) {
		this.servicio = servicio;
	}
	public List<MenuItem> getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(List<MenuItem> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}   
    
}
