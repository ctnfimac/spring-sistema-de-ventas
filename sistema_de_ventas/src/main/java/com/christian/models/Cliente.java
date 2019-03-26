package com.christian.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Cliente extends Usuario{
	private String direccionCalle;
	private String direccionAltura;
	
	@ManyToOne (cascade={CascadeType.ALL})
	private Localidad localidad;

	public Cliente(){}
	
	public String getDireccionCalle() {
		return direccionCalle;
	}
	public void setDireccionCalle(String direccionCalle) {
		this.direccionCalle = direccionCalle;
	}
	
	public String getDireccionAltura() {
		return direccionAltura;
	}
	public void setDireccionAltura(String direccionAltura) {
		this.direccionAltura = direccionAltura;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
}