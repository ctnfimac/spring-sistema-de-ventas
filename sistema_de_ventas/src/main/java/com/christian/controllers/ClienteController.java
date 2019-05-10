package com.christian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Cliente;

@Controller
public class ClienteController {
	
	@RequestMapping(path="/cliente", method = RequestMethod.GET)
	public ModelAndView cliente(){
		return new ModelAndView("cliente");
	}
	
	@RequestMapping(path="/registrarCliente", method = RequestMethod.POST)
	@ResponseBody public String registrarCliente(@ModelAttribute("Cliente") Cliente cliente){
		System.out.println("nombre: " + cliente.getNombre());
		System.out.println("email: " + cliente.getEmail());
		System.out.println("localidad: " + cliente.getLocalidadNombre());
		return "registrando...";
	}
}
