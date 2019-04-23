package com.christian.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.christian.models.Categoria;
import com.christian.models.Producto;


@Repository("ProductoDao")
public class ProductoDaoImpl implements ProductoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarProducto(Producto producto) {
		final Session session = sessionFactory.getCurrentSession();
		
		Categoria categoria = (Categoria) session.createCriteria(Categoria.class)
				.add(Restrictions.eq("nombre", producto.getCategoria().getNombre()))
				.uniqueResult();
		producto.setCategoria(categoria);
		session.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Producto productoAeliminar = (Producto) session.createCriteria(Producto.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();

		if (productoAeliminar != null) session.delete(productoAeliminar);
	}

	@Override
	public void modificarProducto(Producto productoViejo, Producto productoNuevo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto obtenerProducto(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Producto producto = null;
		producto = (Producto) session.createCriteria(Producto.class)
			.add(Restrictions.eq("id", id))
			.uniqueResult();
		return producto;
	}

	@Override
	public void cargarProductos() {
		final Session session = sessionFactory.getCurrentSession();
		
		Categoria categoria1 = new Categoria("Boards-Modules");
		Categoria categoria2 = new Categoria("Shields");
		
		session.save(categoria1);
		session.save(categoria2);
		
		Producto producto1 = new Producto("Arduino MKR GSM 1400",
				"ABX00018-B",
				"./img/productos/ArduinoMKRGSM1400.jpg",
				"Arduino MKR GSM 1400 - global 3G GSM connectivity with powerful Microchip ATSAMD21", 
				10, 
				69.9);
		Producto producto2 = new Producto("Arduino Mega 2560 Rev3",
				"A000067",
				"./img/productos/ArduinoMega2560Rev3.jpg",
				"The MEGA 2560 is designed for more complex projects. With 54 digital I/O pins, 16 analog inputs", 
				8, 
				38.50);
		Producto producto3 = new Producto("Shield - Xbee",
				"A000007",
				"./img/productos/Shield-Xbee.jpg",
				"The Xbee shield allows an Arduino board to communicate wirelessly using Zigbee.", 
				14, 
				28.90);
		Producto producto4 = new Producto("Arduino Ethernet Shield 2",
				"A000024",
				"./img/productos/ArduinoEthernetShield2.jpg",
				"Connects your Arduino to the internet in mere minutes. controlling your world through the internet", 
				10, 
				23.65);
		
		producto1.setCategoria(categoria1);
		producto2.setCategoria(categoria1);
		producto3.setCategoria(categoria2);
		producto4.setCategoria(categoria2);
		
		session.save(producto1);
		session.save(producto2);
		session.save(producto3);
		session.save(producto4);
	}

	@Override
	public Integer cantidadDeProductos() {
		Session session = sessionFactory.getCurrentSession();
		Integer cantidad = null;
		List<Producto> productos = session.createCriteria(Producto.class).list();
		cantidad = productos.size();
		return cantidad;
	}

	@Override
	public List<Producto> getProductos() {
		final Session session = sessionFactory.getCurrentSession();
		List<Producto> productos = null;
		productos = session.createCriteria(Producto.class).list();
		return productos;
	}

	@Override
	public List<Categoria> getCategorias() {
		final Session session = sessionFactory.getCurrentSession();
		List<Categoria> categorias = null;
		categorias = session.createCriteria(Categoria.class)
				.list();
		return categorias;
	}

	@Override
	public List<Producto> paginacion(Integer from, Integer quantity) {
		final Session session = sessionFactory.getCurrentSession();
		List<Producto> productosAmostrar = null;
		productosAmostrar = session.createCriteria(Producto.class)
				.setFirstResult(from)
//				.setFetchSize(quantity)
				.setMaxResults(quantity)
				.list();
		return productosAmostrar;
	}

}
