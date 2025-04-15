package com.AJL.travelnest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class HorarioAtencion {
    private String dia;
    private String apertura;
    private String cierre;
}
