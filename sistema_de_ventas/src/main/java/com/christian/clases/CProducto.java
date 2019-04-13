package com.christian.clases;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CProducto {
	private CommonsMultipartFile file;
	private String code;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private Double precio;
	private String categoria;
	
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
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "CProducto [code=" + code + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + ", categoria=" + categoria + "]";
	}
//	@Override
//	public String toString() {
//		return "CProducto [code=" + code + ", nombre=" + nombre + ", descripcion=" + descripcion + ", file=" + file.getOriginalFilename()
//				+ ", cantidad=" + cantidad + ", precio=" + precio + ", categoria=" + categoria + "]";
//	}
	
	
	
	
	
	
	
	
}
