package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.models.Cliente;
import com.christian.models.Localidad;
import com.christian.services.AdminService;
import com.christian.services.ClienteService;

@Controller
public class LoginController {
	
	@Inject 
	ClienteService clienteService;
	
	@Inject
	private AdminService adminService;
	
	@RequestMapping(path="/login", method =  RequestMethod.GET)
	public ModelAndView irALogin(){
		ModelMap modelo = new ModelMap();
		List<Localidad> localidades = clienteService.obtenerLocalidades();
		modelo.put("localidades", localidades);
		return new ModelAndView("login",modelo);
	}
	
	@RequestMapping(path="/loginVerificacion", method= RequestMethod.POST)
	@ResponseBody
	public String verificacionDelLogin(@ModelAttribute("Admin") Admin admin,HttpServletRequest request){
		String respuesta = "error";
		
		if(admin.getUsuario().equals("") || admin.getPassword().equals("")){
			respuesta = "vacio";
		}else{
			Admin administrador = adminService.getAdmin(admin.getUsuario(), admin.getPassword());
			if(administrador != null){
				HttpSession session = request.getSession();
				respuesta = administrador.getUsuario();
				session.setAttribute("admin", administrador);	
			}
		}
		return respuesta;
	}
	
	@RequestMapping(path="/adminSalir")
	public ModelAndView adminSalir(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return new ModelAndView("redirect:index");
	}
}
