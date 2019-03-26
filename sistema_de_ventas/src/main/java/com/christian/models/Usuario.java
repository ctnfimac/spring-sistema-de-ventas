package com.christian.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario{
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String email;
	private String password;
	private String habilitado;
	
	public Usuario(){}
	
	public Usuario(String nombre, String email, String password, String habilitado) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.habilitado = habilitado;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	
}
