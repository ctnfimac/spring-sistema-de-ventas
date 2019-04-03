package com.christian.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.services.AdminService;
import com.christian.services.ClienteService;
import com.christian.services.ProductoService;

@Controller
public class DatosController {
	
	@Inject
	private AdminService servicioAdmin;
	
	@Inject 
	private ProductoService servicioProducto;
	
	@Inject
	private ClienteService clienteService;
	
	@RequestMapping(path="/load",method=RequestMethod.GET)
	public ModelAndView load(){
		if(servicioProducto.cantidadDeProductos() == 0 || servicioProducto.cantidadDeProductos() == null ){
			servicioAdmin.addAdmin(new Admin("christian","spring"));
			servicioProducto.cargarProductos();
			clienteService.loadClientes();
		}
			
		return new ModelAndView("redirect:/index");
	}
}
