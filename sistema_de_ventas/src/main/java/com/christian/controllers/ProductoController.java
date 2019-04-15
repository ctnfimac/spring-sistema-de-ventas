package com.christian.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.christian.clases.CProducto;
import com.christian.clases.Ruta;
import com.christian.models.Categoria;
import com.christian.models.Producto;
import com.christian.services.ProductoService;
import com.google.gson.Gson;



@Controller
public class ProductoController {
	
	@Inject
	private ProductoService productoService;
	
	
	@ResponseBody
	@RequestMapping(path="/recibeProducto", method = RequestMethod.POST)
	public String agregandoProducto(@ModelAttribute("cProducto") CProducto producto) throws IOException{
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

		 //guardar el producto nuevo en la ddbb
		 Producto productoNuevo = new Producto(producto.getNombre(),producto.getCode(), 
				 pathImg, producto.getDescripcion(),
				 producto.getCantidad(), producto.getPrecio());
		 productoNuevo.setCategoria(new Categoria(producto.getCategoria()));
		 
		 productoService.agregarProducto(productoNuevo);
		 
		 List<Producto> productosActualizados = productoService.getProductos();

		 Gson gson = new Gson();
		 String JSON = gson.toJson(productosActualizados);
		 return JSON;
	}

	@ResponseBody
	@RequestMapping(path="muestraProductos", method= RequestMethod.POST)
	public String muestraProductos(){
		Gson gson = new Gson();
		List<Producto> productosActualizados = productoService.getProductos();
		String JSON = gson.toJson(productosActualizados);
		return JSON;
	}
	
}
