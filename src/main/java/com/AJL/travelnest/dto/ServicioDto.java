package com.AJL.travelnest.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ServicioDto {

    @NotBlank(message = "El tipo es obligatorio")
    private TipoServicio tipo;

    @NotNull(message = "Las características no pueden ser nulas")
    private CaracteristicasDTO caracteristicas;

    private List<String> tipoAmbiente;
    @Valid
	private List<HorarioDTO> horarioAtencion;
	@Valid
    private List<MenuItemDto> menuPrincipal;

    // Validación manual que puedes ejecutar en tu servicio 
    public void validarCamposCondicionales() {
        if (TipoServicio.BAR.equals(tipo)) {
            if (tipoAmbiente == null || tipoAmbiente.isEmpty()) {
                throw new IllegalArgumentException("El tipoAmbiente no puede estar vacío si el tipo es 'bar'");
            }
        }
    }
    
	public ServicioDto() {
		super();
	}


	public ServicioDto(@NotBlank(message = "El tipo es obligatorio") TipoServicio tipo,
			@NotNull(message = "Las características no pueden ser nulas") CaracteristicasDTO caracteristicas,
			List<String> tipoAmbiente, @Valid List<HorarioDTO> horarioAtencion,
			@Valid List<MenuItemDto> menuPrincipal) {
		super();
		this.tipo = tipo;
		this.caracteristicas = caracteristicas;
		this.tipoAmbiente = tipoAmbiente;
		this.horarioAtencion = horarioAtencion;
		this.menuPrincipal = menuPrincipal;
	}

	public TipoServicio getTipo() {
		return tipo;
	}

	public void setTipo(TipoServicio tipo) {
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

	public List<HorarioDTO> getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(List<HorarioDTO> horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public List<MenuItemDto> getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(List<MenuItemDto> menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	
	
}
