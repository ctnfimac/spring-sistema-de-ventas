package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.models.Producto;
import com.christian.services.AdminService;
import com.christian.services.ProductoService;

@Controller
public class IndexController {
	
	@Inject
	private AdminService servicioAdmin;
	
	@Inject 
	private ProductoService servicioProducto;
	
	
	@RequestMapping(path={"/index","/"}, method = RequestMethod.GET)
	public ModelAndView index(){
//		servicioAdmin.addAdmin(new Admin("christian","spring"));
//		if(servicioProducto.cantidadDeProductos() == 0 || servicioProducto.cantidadDeProductos() == null )
//			servicioProducto.cargarProductos();
		ModelMap modelo = new ModelMap();
		List<Producto> productos = servicioProducto.getProductos();
		
		modelo.put("productos", productos);
		return new ModelAndView("index",modelo);
	}
}
