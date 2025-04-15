package com.AJL.travelnest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class MenuItem {
    private String nombrePlato;
    private String descripcion;
    private double precio;
    private String categoria;
}
