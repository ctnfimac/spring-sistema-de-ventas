package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Cliente;
import com.christian.services.ClienteService;
import com.christian.services.ProductoService;

@Controller
public class AdminController {

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private ProductoService productoService;
	
	@RequestMapping(path="/admin", method=RequestMethod.GET)
	public ModelAndView irAadmin(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null){
			ModelMap modelo = new ModelMap();
			List<Cliente> clientes = clienteService.getClientes();
			modelo.put("clientes", clientes);
			return new ModelAndView("admin",modelo);
		}else{
			return new ModelAndView("redirect:login");
		}
		
	}
	
	@RequestMapping(path="/habilitacionDeCliente", method = RequestMethod.GET)
	public @ResponseBody String habilitacionDeCliente(@RequestParam(value="id") Long id){
		String result = clienteService.cambiarEstadoPorId(id);
		return result;
	}
	
	@RequestMapping(path="/eliminacionCliente", method=RequestMethod.GET)
	public @ResponseBody String eliminacionCliente(@RequestParam(value="id") Long id){
		clienteService.deleteCliente(id);
		return "se elimino correctamente";
	}
	
	
}
