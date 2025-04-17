package com.AJL.travelnest.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "servicios")
public class Servicio {
	 @Id
	 private String id;
	 private CaracteristicaServicio caracteristicas;
	 private String tipo;
	 private List<String> tipoAmbiente;
	 private List<HorarioAtencion> horarioAtencion;
	 private List<MenuItem> menuPrincipal;
	 
	 
	public Servicio() {
		super();
	}
	public Servicio(String id, CaracteristicaServicio caracteristicas, String tipo, List<String> tipoAmbiente,
			List<HorarioAtencion> horarioAtencion, List<MenuItem> menuPrincipal) {
		super();
		this.id = id;
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.tipoAmbiente = tipoAmbiente;
		this.horarioAtencion = horarioAtencion;
		this.menuPrincipal = menuPrincipal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CaracteristicaServicio getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(CaracteristicaServicio caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<String> getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(List<String> tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	public List<HorarioAtencion> getHorarioAtencion() {
		return horarioAtencion;
	}
	public void setHorarioAtencion(List<HorarioAtencion> horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}
	public List<MenuItem> getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(List<MenuItem> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}	 
	
}
