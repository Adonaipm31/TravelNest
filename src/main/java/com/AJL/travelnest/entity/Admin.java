package com.AJL.travelnest.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Usuario implements Serializable {
	private Date fecha_ingreso;

}
