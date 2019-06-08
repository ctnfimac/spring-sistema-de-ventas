package com.christian.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.models.Localidad;
import com.christian.models.Usuario;
import com.christian.services.AdminService;
import com.christian.services.ClienteService;
import com.christian.services.UsuarioService;

@Controller
public class LoginController {
	
	@Inject 
	ClienteService clienteService;
	
	@Inject
	private AdminService adminService;
	
	@Inject 
	private UsuarioService usuarioService;
	
	@RequestMapping(path="/login", method =  RequestMethod.GET)
	public ModelAndView irALogin(){
		ModelMap modelo = new ModelMap();
		List<Localidad> localidades = clienteService.obtenerLocalidades();
		modelo.put("localidades", localidades);
		return new ModelAndView("login",modelo);
	}
	
	@RequestMapping(path="/loginVerificacion", method= RequestMethod.POST)
	@ResponseBody
	public String loginVerificacion(@ModelAttribute("Usuario") Usuario usuario,HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(usuario.getEmail().equals("") || usuario.getPassword().equals("")){
			json.put("respuesta", "vacio");
		}else{
			Usuario usuarioBuscado = usuarioService.getUsuario(usuario.getEmail(), usuario.getPassword());
			if(usuarioBuscado != null){
				HttpSession session = request.getSession();
				session.setAttribute("usuarioNombre", usuarioBuscado.getNombre());
				session.setAttribute("usuarioId", usuarioBuscado.getId());
				session.setAttribute("usuarioRol", usuarioBuscado.getRol());
				json.put("nombre", usuarioBuscado.getNombre());
				json.put("rol", usuarioBuscado.getRol());
			}else json.put("respuesta", "error");
		}
		return json.toJSONString();
	}
	
	@RequestMapping(path="/adminSalir")
	public ModelAndView adminSalir(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping(path="/usuarioSalir")
	public ModelAndView usuarioSalir(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioNombre");
		session.removeAttribute("usuarioRol");
		session.removeAttribute("usuarioId");
		return new ModelAndView("redirect:login");
	}
}
