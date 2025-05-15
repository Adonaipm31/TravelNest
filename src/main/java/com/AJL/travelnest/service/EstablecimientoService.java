package com.AJL.travelnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.HorarioDTO;
import com.AJL.travelnest.dto.EstablecimientoDto;
import com.AJL.travelnest.dto.TipoServicio;
import com.AJL.travelnest.entity.CaracteristicaServicio;
import com.AJL.travelnest.entity.HorarioAtencion;
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
	    
	    public List<Establecimiento> obtenerRooftop() {
	        return servicioRepository.findByTipo(TipoServicio.ROOFTOP);
	    }
	    
	    public List<Establecimiento> listar() {
	        return servicioRepository.findAll();
	    }
	    
	    public List<Establecimiento> listarTipo(TipoServicio tipo) {
	        return servicioRepository.findByTipo(tipo);
	    }

	    public Establecimiento registrarServicio(EstablecimientoDto servicioDTO) {

	        Establecimiento servicio = mapearDTOaEntidad(servicioDTO);
	        return servicioRepository.save(servicio);
	    }
	    
	    public List<Establecimiento> obtenerTodo() {
	        return servicioRepository.findAll();
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

	    private Establecimiento mapearDTOaEntidad(EstablecimientoDto dto) {
	        Establecimiento servicio = new Establecimiento();

	        CaracteristicaServicio caracteristicas = new CaracteristicaServicio();
	        caracteristicas.setNombre(dto.getCaracteristicas().getNombre());
	        caracteristicas.setTelefono(dto.getCaracteristicas().getTelefono());
	        caracteristicas.setImage(dto.getCaracteristicas().getImage());
	        caracteristicas.setDireccion(dto.getCaracteristicas().getDireccion());
	        caracteristicas.setCalificacion(dto.getCaracteristicas().getCalificacion());
	        caracteristicas.setPrecioPromedio(dto.getCaracteristicas().getPrecioPromedio());
	        servicio.setTipo(dto.getTipo());
	        servicio.setTipoAmbiente(dto.getTipoAmbiente());
	        servicio.setHorarioAtencion(mapearHorarioAtencion(dto.getHorarioAtencion()));
	        servicio.setTipoCosina(dto.getTipoCosina());
	        servicio.setCaracteristicas(caracteristicas);

	        return servicio;
	    }

	   
}
