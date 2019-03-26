package com.christian.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Localidad {
	@Id 
	@GeneratedValue
	private Long id;
	private String nombre;
	
	public Localidad(){}
	
	public Localidad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
