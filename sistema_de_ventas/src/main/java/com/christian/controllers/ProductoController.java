package com.christian.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.christian.clases.CProducto;
import com.christian.clases.Ruta;
import com.christian.models.Categoria;
import com.christian.models.Producto;
import com.christian.services.ProductoService;
import com.google.gson.Gson;



@Controller
public class ProductoController {
	
	private final Integer NPRODUCTOS = 2;
	
	@Inject
	private ProductoService productoService;
	
	
	@RequestMapping(path="/productos")
	public ModelAndView irAproductos(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null){
			ModelMap modelo = new ModelMap();	
			List<Categoria> categorias = null;
			categorias = productoService.getCategorias();
			modelo.put("categorias", categorias);
			return new ModelAndView("productos",modelo);
		}else{
			return new ModelAndView("redirect:login");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/recibeProducto", method = RequestMethod.POST)
	public String agregandoProducto(@ModelAttribute("cProducto") CProducto producto) throws IOException{
		 String JSON = "error";
		 if(this.validacionDeFormDeProducto(producto)){
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
			 JSON = gson.toJson(productosActualizados);
		 }
		 return JSON;
	}
	
	private Boolean validacionDeFormDeProducto(CProducto producto){
		Boolean resultado = true;
		try{
			if(producto.getCode().equals("") || producto.getNombre().equals("") || producto.getDescripcion().toString().equals("") 
					|| producto.getCantidad().toString().equals("NaN") || producto.getPrecio().toString().equals("NaN") || producto.getCategoria().toString().equals("0")
					|| producto.getFile().equals(null) )
				resultado = false;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	@ResponseBody
	@RequestMapping(path="muestraProductos", method= RequestMethod.POST)
	public String muestraProductos(){
		Gson gson = new Gson();
		List<Producto> productosActualizados = productoService.paginacion(0, NPRODUCTOS);//productoService.getProductos();
		String JSON = gson.toJson(productosActualizados);
		return JSON;
	}
	
	@ResponseBody
	@RequestMapping(path="muestraProductos/{indice}", method= RequestMethod.GET)
	public String muestraProductosEspecificos(@PathVariable Integer indice){
		Gson gson = new Gson();
		List<Producto> productosActualizados = productoService.paginacion((indice-1)*NPRODUCTOS, NPRODUCTOS);//productoService.getProductos();
		String JSON = gson.toJson(productosActualizados);
		return JSON;
	}
	
	
	@ResponseBody
	@RequestMapping(path="paginacion", method= RequestMethod.POST)
	public String paginacionDeProductos(){
		JSONObject json = new JSONObject();
		Integer cantidadTotal = productoService.getProductos().size();
		json.put("total", cantidadTotal);
		json.put("productosAmostrar", NPRODUCTOS);
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(path="eliminarProductoAJax/{id}/{indicePaginaActual}", method = RequestMethod.GET)
	public String eliminarProducto(@PathVariable Long id, @PathVariable Integer indicePaginaActual){
		JSONObject json = new JSONObject();
		
		System.out.println("pagina actual:" + indicePaginaActual);
		
		// elimino la imagen de la carpeta
		Producto producto = productoService.obtenerProducto(id);
		String urlimg = producto.getUrlimg();
		
		String nameimg =urlimg.replace("./img/productos", "");
		urlimg = Ruta.PRODUCTOS + nameimg;
	
		
		File imagenAeliminar = new File(urlimg);
		if(imagenAeliminar != null)imagenAeliminar.delete();
		
		// elimino  el producto de la tabla producto
		productoService.eliminarProducto(id);
		
		// verifico si hay o no productos en la tabla
		List<Producto> productos = productoService.getProductos();

		if(productos.size()!=0){
			json.put("respuesta", "novacio");
			List<Producto> productosDeLaPaginacionActual = productoService.paginacion((indicePaginaActual-1)*NPRODUCTOS, NPRODUCTOS);
			if(productosDeLaPaginacionActual.size() == 0){
				if(indicePaginaActual == 1)	indicePaginaActual = 2;
				else indicePaginaActual--;
			}
			json.put("indicePaginaActual", indicePaginaActual);
			
		}else	json.put("respuesta", "vacio");
		
		return json.toJSONString();
	}

	
}
