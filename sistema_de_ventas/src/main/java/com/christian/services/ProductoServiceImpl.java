package com.christian.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.ProductoDao;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProducto(Producto productoViejo, Producto productoNuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerProducto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer cantidadDeProductos() {
		return productoDao.cantidadDeProductos();
	}

	@Override
	public List<Producto> getProductos() {
		return productoDao.getProductos();
	}

}
