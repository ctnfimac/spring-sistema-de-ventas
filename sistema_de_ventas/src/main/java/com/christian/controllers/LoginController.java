package com.christian.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.services.AdminService;

@Controller
public class LoginController {
	
	@Inject
	private AdminService adminService;
	
	@RequestMapping(path="/login", method =  RequestMethod.GET)
	public String irALogin(){
		return "login";
	}
	
	@RequestMapping(path="/loginVerificacion", method= RequestMethod.POST)
	@ResponseBody
	public String verificacionDelLogin(@ModelAttribute("Admin") Admin admin,HttpServletRequest request){
		String respuesta = "error";
		
		Admin administrador = adminService.getAdmin(admin.getUsuario(), admin.getPassword());
		System.out.println("administrador:" + administrador);
		if(administrador != null){
			HttpSession session = request.getSession();
			respuesta = administrador.getUsuario();
			session.setAttribute("admin", administrador);	
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
