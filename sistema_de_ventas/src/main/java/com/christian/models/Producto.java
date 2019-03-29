package com.christian.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Producto {
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String code;
	
	private String nombre;
	private String descripcion;
	private String urlimg;
	private Integer cantidad;
	private Double precio;
	
	@ManyToOne (cascade = { CascadeType.ALL })
	private Categoria categoria;
	
	public Producto(){}

	public Producto(String nombre,String code, String urlimg, String descripcion, Integer cantidad, Double d) {
		this.nombre = nombre;
		this.code = code;
		this.urlimg = urlimg;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = d;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
