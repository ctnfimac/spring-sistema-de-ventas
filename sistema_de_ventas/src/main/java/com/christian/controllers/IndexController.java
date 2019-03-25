package com.christian.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Admin;
import com.christian.services.AdminService;

@Controller
public class IndexController {
	
	@Inject
	private AdminService servicioAdmin;
	
	@RequestMapping(path={"/index","/"}, method = RequestMethod.GET)
	public ModelAndView index(){
		servicioAdmin.addAdmin(new Admin("christian","spring"));
		return new ModelAndView("index");
	}
}
