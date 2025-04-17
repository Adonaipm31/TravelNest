package com.AJL.travelnest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoServicio {
	BAR,
	RESTAURANTE,
	HOTEL;
	
	@JsonCreator
    public static TipoServicio fromString(String value) {
        return TipoServicio.valueOf(value.toUpperCase());
    }
}
