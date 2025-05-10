package com.AJL.travelnest.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.AJL.travelnest.dto.TipoServicio;

@Document(collection = "servicios")
public class Establecimiento {
	 @Id
	 private String id;
	 private CaracteristicaServicio caracteristicas;
	 private TipoServicio tipo;
	 private List<String> tipoAmbiente;
	 private List<HorarioAtencion> horarioAtencion;
	 private List<MenuItemP> menuPrincipal;
	 
	 
	public Establecimiento() {
		super();
	}

	public Establecimiento(String id, CaracteristicaServicio caracteristicas, TipoServicio tipo, List<String> tipoAmbiente,
			List<HorarioAtencion> horarioAtencion, List<MenuItemP> menuPrincipal) {
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


	public TipoServicio getTipo() {
		return tipo;
	}


	public void setTipo(TipoServicio tipo) {
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


	public List<MenuItemP> getMenuPrincipal() {
		return menuPrincipal;
	}


	public void setMenuPrincipal(List<MenuItemP> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}



	
}
