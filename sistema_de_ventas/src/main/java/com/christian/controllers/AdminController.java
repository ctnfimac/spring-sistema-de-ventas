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

import com.christian.clases.CProducto;
import com.christian.models.Categoria;
import com.christian.models.Cliente;
import com.christian.models.Producto;
import com.christian.services.ClienteService;
import com.christian.services.ProductoService;

@Controller
public class AdminController {

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private ProductoService productoService;
	
	@RequestMapping(path="/admin", method=RequestMethod.GET)
	public ModelAndView irAadmin(){
		ModelMap modelo = new ModelMap();
		List<Cliente> clientes = clienteService.getClientes();
		modelo.put("clientes", clientes);
		return new ModelAndView("admin",modelo);
	}
	
	@RequestMapping(path="/productos")
	public ModelAndView irAproductos(){
		ModelMap modelo = new ModelMap();
		List<Producto> productos = null;
		productos = productoService.getProductos();
		
		List<Categoria> categorias = null;
		categorias = productoService.getCategorias();
		
		CProducto cproducto = new CProducto();
		
		modelo.put("productos", productos);
		modelo.put("categorias", categorias);
		modelo.put("cproducto", cproducto);
		return new ModelAndView("productos",modelo);
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
