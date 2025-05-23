package com.AJL.travelnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.dto.HorarioDTO;
import com.AJL.travelnest.dto.CaracteristicasDTO;
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
	    
	    @Cacheable(value = "establecimientos", key = "'hoteles'")
	    public List<Establecimiento> obtenerHoteles() {
	        return servicioRepository.findByTipo(TipoServicio.HOTEL);
	    }
	    @Cacheable(value = "establecimientos", key = "'bares'")
	    public List<Establecimiento> obtenerBares() {
	        return servicioRepository.findByTipo(TipoServicio.BAR);
	    }
	    
	    @Cacheable(value = "establecimientos", key = "'restaurantes'")
	    public List<Establecimiento> obtenerRestaurante() {
	        return servicioRepository.findByTipo(TipoServicio.RESTAURANTE);
	    }
	    
	    public List<Establecimiento> obtenerRooftop() {
	        return servicioRepository.findByTipo(TipoServicio.ROOFTOP);
	    }
	    
	    @Cacheable(value = "establecimientos")
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
	    
	    private void actualizarEntidadDesdeDTO(Establecimiento entidad, EstablecimientoDto dto) {
	        entidad.setTipo(dto.getTipo());
	        entidad.setTipoAmbiente(dto.getTipoAmbiente());
	        entidad.setTipoCosina(dto.getTipoCosina());
	        entidad.setHorarioAtencion(mapearHorarioAtencion(dto.getHorarioAtencion()));

	        CaracteristicaServicio caracteristicas = entidad.getCaracteristicas();
	        if (dto.getCaracteristicas() == null) {
	            caracteristicas = new CaracteristicaServicio();
	            entidad.setCaracteristicas(caracteristicas);
	        }

	        caracteristicas.setNombre(dto.getCaracteristicas().getNombre());
	        caracteristicas.setTelefono(dto.getCaracteristicas().getTelefono());
	        caracteristicas.setImage(dto.getCaracteristicas().getImage());
	        caracteristicas.setDireccion(dto.getCaracteristicas().getDireccion());
	        caracteristicas.setCalificacion(dto.getCaracteristicas().getCalificacion());
	        caracteristicas.setPrecioPromedio(dto.getCaracteristicas().getPrecioPromedio());
	    }
	    
	    public EstablecimientoDto mapearEntidadADTO(Establecimiento entidad) {
	        EstablecimientoDto dto = new EstablecimientoDto();
	        
	        dto.setTipo(entidad.getTipo());
	        dto.setTipoAmbiente(entidad.getTipoAmbiente());
	        dto.setTipoCosina(entidad.getTipoCosina());
	        CaracteristicaServicio caracteristicas = entidad.getCaracteristicas();
	        if (caracteristicas != null) {
	            CaracteristicasDTO caracteristicaDto = new CaracteristicasDTO();
	            caracteristicaDto.setNombre(caracteristicas.getNombre());
	            caracteristicaDto.setTelefono(caracteristicas.getTelefono());
	            caracteristicaDto.setImage(caracteristicas.getImage());
	            caracteristicaDto.setDireccion(caracteristicas.getDireccion());
	            caracteristicaDto.setCalificacion(caracteristicas.getCalificacion());
	            caracteristicaDto.setPrecioPromedio(caracteristicas.getPrecioPromedio());
	            dto.setCaracteristicas(caracteristicaDto);
	        }
	        
	        if (entidad.getHorarioAtencion() != null) {
	            List<HorarioDTO> listaHorarios = entidad.getHorarioAtencion().stream().map(horario -> {
	                HorarioDTO horarioDTO = new HorarioDTO();
	                horarioDTO.setDia(horario.getDia());
	                horarioDTO.setHoraApertura(horario.getApertura());
	                horarioDTO.setHoraCierre(horario.getCierre());
	                return horarioDTO;
	            }).collect(Collectors.toList());

	            dto.setHorarioAtencion(listaHorarios);
	        }

	        return dto;
	    }

	    public List<Establecimiento> buscarPorNombre(String nombre) {
	        return servicioRepository.findByCaracteristicasNombreContainingIgnoreCase(nombre);
	    }
	    
	    public Optional<Establecimiento> buscarPorId(String id) {
	        return servicioRepository.findById(id);
	    }
	    
	    @Cacheable(value = "establecimientos", key = "#id")
	    public Establecimiento obtenerPorId(String id) {
	        return servicioRepository.findById(id)
	            .orElse(null);
	    }
	    
	    public Establecimiento actualizar(String id, EstablecimientoDto esta) {
	    	Establecimiento establecimiento = servicioRepository.findById(id)
	    			.orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con ID: " + id));  	

	        actualizarEntidadDesdeDTO(establecimiento, esta);	    		
	    	return servicioRepository.save(establecimiento);
			
	    }
	    
	    public void eliminar(String id) {
	    	Establecimiento establecimiento = servicioRepository.findById(id)
	    			.orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con ID: " + id));  	

	    	servicioRepository.delete(establecimiento);
	    }	    	
	   
}