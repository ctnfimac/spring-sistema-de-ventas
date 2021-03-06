package com.christian.services;

import java.util.List;

import com.christian.models.Categoria;
import com.christian.models.Producto;

public interface ProductoService {
	void cargarProductos();
	void agregarProducto(Producto producto);
	void eliminarProducto(Long id);
	void modificarProducto(Producto productoViejo, Producto productoNuevo);
	Producto obtenerProducto(Long id);
	Integer cantidadDeProductos();
	List<Producto> getProductos();
	List<Categoria> getCategorias();
	List<Producto> paginacion(Integer from, Integer quantity);
}
