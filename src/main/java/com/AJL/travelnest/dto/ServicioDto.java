package com.AJL.travelnest.dto;

import java.util.List;

import com.AJL.travelnest.entity.HorarioAtencion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class ServicioDto {

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    @NotNull(message = "Las características no pueden ser nulas")
    private CaracteristicasDTO caracteristicas;

    private List<String> tipoAmbiente;
    
	private List<HorarioAtencion> horarioAtencion;

    private List<String> menuPrincipal;

    // Validación manual que puedes ejecutar en tu servicio o controlador
    public void validarCamposCondicionales() {
        if ("bar".equalsIgnoreCase(tipo)) {
            if (tipoAmbiente == null || tipoAmbiente.isEmpty()) {
                throw new IllegalArgumentException("El tipoAmbiente no puede estar vacío si el tipo es 'bar'");
            }
        }
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CaracteristicasDTO getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(CaracteristicasDTO caracteristicas) {
		this.caracteristicas = caracteristicas;
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

	public List<String> getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(List<String> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
    
    
}
