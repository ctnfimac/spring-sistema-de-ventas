package com.christian.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.christian.services.ProductoService;

@Controller
public class ProductoController {
	@Inject
	private ProductoService productoService;
	
	
//	@RequestParam(path="/cargarProductos")
//	public ModelAndView cargarProductos(){
//		if(productoService.cantidadDeProductos() == 0)
//	}
}
