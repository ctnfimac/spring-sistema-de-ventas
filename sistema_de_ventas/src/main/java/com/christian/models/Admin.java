package com.christian.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	
	// propiedades
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String usuario;
	private String password;
	private String rol = "admin";
	
	// constructores
	
	public Admin(){}
	public Admin(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	
	// setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
