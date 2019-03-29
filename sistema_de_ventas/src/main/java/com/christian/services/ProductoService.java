package com.christian.services;

import java.util.List;

import com.christian.models.Producto;

public interface ProductoService {
	void cargarProductos();
	void agregarProducto(Producto producto);
	void eliminarProducto(Producto producto);
	void modificarProducto(Producto productoViejo, Producto productoNuevo);
	Producto obtenerProducto(Long id);
	Integer cantidadDeProductos();
	List<Producto> getProductos();
}
