package com.AJL.travelnest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Turista extends Usuario implements Serializable{

	private String email;
	
}
