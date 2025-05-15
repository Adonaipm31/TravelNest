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
	 private List<String> tipoCosina;
	 	 
	public Establecimiento() {
		super();
	}

	public Establecimiento(String id, CaracteristicaServicio caracteristicas, TipoServicio tipo,
			List<String> tipoAmbiente, List<HorarioAtencion> horarioAtencion, List<String> menuPrincipal) {
		super();
		this.id = id;
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.tipoAmbiente = tipoAmbiente;
		this.horarioAtencion = horarioAtencion;
		this.tipoCosina = menuPrincipal;
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

	public List<String> getTipoCosina() {
		return tipoCosina;
	}

	public void setTipoCosina(List<String> menuPrincipal) {
		this.tipoCosina = menuPrincipal;
	}
	 	
}
