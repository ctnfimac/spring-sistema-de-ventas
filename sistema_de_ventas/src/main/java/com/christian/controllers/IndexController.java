package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Producto;
import com.christian.services.ProductoService;

@Controller
public class IndexController {

	
	@Inject 
	private ProductoService servicioProducto;
	
	
	@RequestMapping(path={"/index","/"}, method = RequestMethod.GET)
	public ModelAndView index(){
		ModelMap modelo = new ModelMap();
		List<Producto> productos = servicioProducto.getProductos();
		
		modelo.put("productos", productos);
		return new ModelAndView("index",modelo);
	}
}
