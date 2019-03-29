package com.christian.dao;

import java.util.List;

import com.christian.models.Producto;

public interface ProductoDao {
	void cargarProductos();
	void agregarProducto(Producto producto);
	void eliminarProducto(Producto producto);
	void modificarProducto(Producto productoViejo, Producto productoNuevo);
	Producto obtenerProducto(Long id);
	Integer cantidadDeProductos();
	List<Producto> getProductos();
}