package com.christian.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.christian.clases.CProducto;
import com.christian.clases.Ruta;
import com.christian.models.Producto;
import com.christian.services.ProductoService;



@Controller
public class ProductoController {
	
	@Inject
	private ProductoService productoService;
	
	
	@ResponseBody
	@RequestMapping(path="/recibeProducto", method = RequestMethod.POST)
	public String habilitacionDeCliente(@ModelAttribute("cProducto") CProducto producto) throws IOException{
		 CommonsMultipartFile file = producto.getFile();
		 // guardo la imagen en el directorio
		 File dir = new File(Ruta.PRODUCTOS);
		 byte[] bytes = file.getBytes();
		 String name = file.getOriginalFilename();
		 File serverFile = new File(Ruta.PRODUCTOS + File.separator + name);//pathname:
		 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		 stream.write(bytes);
		 stream.close();
		 
		 String pathImg = "./img/productos/" + name;

		 //guardar la url en la base de datos
		 Producto productoNuevo = new Producto(producto.getNombre(),producto.getCode(), 
				 pathImg, producto.getDescripcion(),
				 producto.getCantidad(), producto.getPrecio());

		 productoService.agregarProducto(productoNuevo);
		 return "ok";
	}
	
}
