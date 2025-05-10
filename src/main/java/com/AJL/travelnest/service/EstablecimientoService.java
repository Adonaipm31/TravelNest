package com.AJL.travelnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.HorarioDTO;
import com.AJL.travelnest.dto.MenuItemDto;
import com.AJL.travelnest.dto.ServicioDto;
import com.AJL.travelnest.dto.TipoServicio;
import com.AJL.travelnest.entity.CaracteristicaServicio;
import com.AJL.travelnest.entity.HorarioAtencion;
import com.AJL.travelnest.entity.MenuItemP;
import com.AJL.travelnest.entity.Establecimiento;
import com.AJL.travelnest.repository.EstablecimientoRepository;

@Service
public class EstablecimientoService {
	 private final EstablecimientoRepository servicioRepository;

	    @Autowired
	    public EstablecimientoService(EstablecimientoRepository servicioRepository) {
	        this.servicioRepository = servicioRepository;
	    }

	    public List<Establecimiento> obtenerHoteles() {
	        return servicioRepository.findByTipo(TipoServicio.HOTEL);
	    }
	    
	    public List<Establecimiento> obtenerBares() {
	        return servicioRepository.findByTipo(TipoServicio.BAR);
	    }
	    
	    public List<Establecimiento> obtenerRestaurante() {
	        return servicioRepository.findByTipo(TipoServicio.RESTAURANTE);
	    }

	    public Establecimiento registrarServicio(ServicioDto servicioDTO) {

	        Establecimiento servicio = mapearDTOaEntidad(servicioDTO);
	        return servicioRepository.save(servicio);
	    }
	    
	    public List<Establecimiento> obtenerTodo() {
	        return servicioRepository.findAll();
	    }
	    
	    
	    private List<MenuItemP> mapearMenuPrincipal(List<MenuItemDto> menuDto) {
	        if (menuDto == null) return new ArrayList<>();

	        return menuDto.stream()
	            .map(itemDto -> {
	                MenuItemP item = new MenuItemP();
	                item.setNombrePlato(itemDto.getNombrePlato());
	                item.setDescripcion(itemDto.getDescripcion());
	                item.setPrecio(itemDto.getPrecio());
	                item.setCategoria(itemDto.getCategoria());
	                return item;
	            })
	            .collect(Collectors.toList());
	    }

	    private List<HorarioAtencion> mapearHorarioAtencion(List<HorarioDTO> horarioDto) {
			if (horarioDto == null) return new ArrayList<>();
			
			 return horarioDto.stream()
			            .map(itemHorarioDto -> {
			                HorarioAtencion item = new HorarioAtencion();
			                item.setDia(itemHorarioDto.getDia());
			                item.setApertura(itemHorarioDto.getHoraApertura());
			                item.setCierre(itemHorarioDto.getHoraCierre());
			                return item;
			            })
			            .collect(Collectors.toList());
		}

	    private Establecimiento mapearDTOaEntidad(ServicioDto dto) {
	        Establecimiento servicio = new Establecimiento();

	        CaracteristicaServicio caracteristicas = new CaracteristicaServicio();
	        caracteristicas.setNombre(dto.getCaracteristicas().getNombre());
	        caracteristicas.setTelefono(dto.getCaracteristicas().getTelefono());
	        caracteristicas.setImage(dto.getCaracteristicas().getImage());
	        caracteristicas.setDireccion(dto.getCaracteristicas().getDireccion());
	        servicio.setTipo(dto.getTipo());
	        servicio.setTipoAmbiente(dto.getTipoAmbiente());
	        servicio.setHorarioAtencion(mapearHorarioAtencion(dto.getHorarioAtencion()));
	        servicio.setMenuPrincipal(mapearMenuPrincipal(dto.getMenuPrincipal()));
	        servicio.setCaracteristicas(caracteristicas);

	        return servicio;
	    }
	    
	    
}
