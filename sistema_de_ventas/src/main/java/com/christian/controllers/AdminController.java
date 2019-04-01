package com.christian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(path="/admin", method=RequestMethod.GET)
	public ModelAndView irAadmin(){
		return new ModelAndView("admin");
	}
}
