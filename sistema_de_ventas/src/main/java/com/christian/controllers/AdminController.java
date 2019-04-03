package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Cliente;
import com.christian.services.ClienteService;

@Controller
public class AdminController {

	@Inject
	private ClienteService clienteService;
	
	@RequestMapping(path="/admin", method=RequestMethod.GET)
	public ModelAndView irAadmin(){
		ModelMap modelo = new ModelMap();
		List<Cliente> clientes = clienteService.getClientes();
		modelo.put("clientes", clientes);
		return new ModelAndView("admin",modelo);
	}
	
	@RequestMapping(path="/habilitacionDeCliente", method = RequestMethod.GET)
	public @ResponseBody String habilitacionDeCliente(@RequestParam(value="id") Long id){
		String result = clienteService.cambiarEstadoPorId(id);
		return result;
	}
}
