package com.christian.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {
	@Id
	private Date fecha;
	private Integer cantidad;
	
	@ManyToOne (cascade = {CascadeType.ALL})
	private Cliente cliente;
	
	@ManyToOne (cascade = {CascadeType.ALL})
	private Producto producto;
	
	public Compra(){}

	public Compra(Date fecha, Integer cantidad, Cliente cliente, Producto producto) {
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
