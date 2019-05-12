package com.christian.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.christian.models.Cliente;
import com.christian.services.ClienteService;

@Controller
public class ClienteController {
	
	@Inject
	private ClienteService clienteService;
	
	@RequestMapping(path="/cliente", method = RequestMethod.GET)
	public ModelAndView cliente(){
		return new ModelAndView("cliente");
	}
	
	@RequestMapping(path="/registrarCliente", method = RequestMethod.POST)
	@ResponseBody public String registrarCliente(@ModelAttribute("Cliente") Cliente cliente){
		JSONObject json = new JSONObject();
		try{
			if(cliente.getNombre().equals("") || cliente.getEmail().equals("") || cliente.getDireccionAltura().equals("")
					|| cliente.getDireccionCalle().equals("") || cliente.getLocalidadNombre().equals("0") 
					|| cliente.getPassword().equals("") || cliente.getPassword2().equals("")){	
				json.put("error", 5);
				json.put("respuesta", "Complete todos los campos por favor");
			}else{
				 //System.out.println("entro aca");
				 String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
				 Pattern pattern = Pattern.compile(emailPattern);
				 Matcher matcher = pattern.matcher(cliente.getEmail());
				 if(!matcher.matches()){
					json.put("error", 3);
					json.put("respuesta", "El email ingresado no es valido");
				 }else if(!cliente.getPassword().equals(cliente.getPassword2())){
					 json.put("error", 4);
					 json.put("respuesta", "Las contrasenias no son iguales");
				 }else{
					 clienteService.addCliente(cliente);
					 json.put("error", 0);
					 json.put("respuesta", "Se ha registrado con éxito Ya puede iniciar sessión");
				 }
			}
		}catch(DataIntegrityViolationException e){
			json.put("error", 2);
			json.put("respuesta", "El email ingresado ya se encuentra registrado");
		}
		return json.toJSONString();
	}
}
