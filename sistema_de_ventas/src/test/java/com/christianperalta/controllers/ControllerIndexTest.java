package com.christianperalta.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.christian.controllers.IndexController;
import com.christian.models.Producto;
import com.christian.services.ProductoService;
//import static org.mockito.Mockito.*;
//import static org.assertj.core.api.Assertions.*;
public class ControllerIndexTest {
	@Mock
	ProductoService productoService;
	
	@InjectMocks
	IndexController indexController;
	
	@Mock
	List<Producto> productos;
	
	@Before
	public void initInjects(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPrueboRetornarLaVistaDeIndex(){
		when(productoService.getProductos()).thenReturn(productos);
		ModelAndView modelo = indexController.index();
		assertThat(modelo.getViewName()).isEqualTo("index");
		assertThat(modelo.getModel()).isNotEmpty();
		assertThat(modelo.getModel().get("productos")).isEqualTo(productos);
	}
}
