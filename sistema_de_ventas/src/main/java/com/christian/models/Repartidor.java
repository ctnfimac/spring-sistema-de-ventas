package com.christian.models;

import javax.persistence.Entity;

@Entity
public class Repartidor extends Usuario{
	private String telefono;
	private Integer estado;
	
	public Repartidor(){
	}
	
	public Repartidor(String nombre, String email, String password, String habilitado,
			String telefono, Integer estado) {
		super(nombre,email,password,habilitado);
		this.telefono = telefono;
		this.estado = estado;
	}

	public Repartidor(String telefono, Integer estado) {
		super();
		this.telefono = telefono;
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
}
