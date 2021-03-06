package com.christian.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.ProductoDao;
import com.christian.models.Categoria;
import com.christian.models.Producto;

@Service("ProductoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Inject
	private ProductoDao productoDao;
	
	@Override
	public void cargarProductos() {
		productoDao.cargarProductos();
	}

	@Override
	public void agregarProducto(Producto producto) {
		productoDao.agregarProducto(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoDao.eliminarProducto(id);
	}

	@Override
	public void modificarProducto(Producto productoViejo, Producto productoNuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerProducto(Long id) {
		return productoDao.obtenerProducto(id);
	}

	@Override
	public Integer cantidadDeProductos() {
		return productoDao.cantidadDeProductos();
	}

	@Override
	public List<Producto> getProductos() {
		return productoDao.getProductos();
	}

	@Override
	public List<Categoria> getCategorias() {
		return productoDao.getCategorias();
	}

	@Override
	public List<Producto> paginacion(Integer from, Integer quantity) {
		return productoDao.paginacion(from, quantity);
	}

}
