const NPRODUCTOS = 2;
paginacionDatos = {
		"paginaEnLaQueEstoy" : 1,
		"ultimaPagina" : 1
}

$(document).ready(function(){
	/*
	 * mostrarProductos()
	 * recibiendo y mostrando los productos de la base de datos
	 * 
	 * */
	function mostrarProductos(){
	  $.ajax({
		    url:'muestraProductos.html',
            type: 'POST',	
            success: function (data) {
            	var productos = JSON.parse(data);
            	var cuerpoDeLaTabla;
            	$("#resultadoDeMostrarProductos" ).empty();
            	productos.forEach(function(dato) {
            		plantillaDeLaTabla(dato);
            	});
            	$('#resultadoDeMostrarProductos').html(cuerpoDeLaTabla);
            },
            error: function (data) {
                console.log(data.id + "error en la petición");
            }
       });
	}
	
	
	/*
	 * Agregar productos
	 * 
	 * */
	$('#btnAddProducto').click(function(e){
		var validacion = validarFormularioDeProductos();
		if(validacion){
			var datos = {
					imagen: jQuery('#imagen')[0].files,
					nombre: $('#nombre').val(),
					code: $('#code').val(),
					cantidad: parseInt($('#cantidad').val()),
					precio: parseFloat($('#precio').val()), 
					categoria: $('#categoria').val(),
					descripcion: $('#descripcion').val()
				};
			enviarPorAjax(datos);
		}
	});
	
	function validarFormularioDeProductos(){
		var resultado = true;
		
		// verifico que todos los campos esten completos
		if($('#nombre').val() == "" || $('#code').val() == "" || $('#cantidad').val()== "" ||
				$('#precio').val()== "" || $('#categoria').val() == "0" || $('#descripcion').val() == "" || 
				document.getElementById("imagen").files.length == 0){
			resultado = false;
			html = '<div class="alert alert-dismissible alert-danger">'  
			  +'<strong>Error!</strong> <a class="alert-link">Complete todos los campos</a> por favor.' 
			  +'</div>';
			document.getElementById('respuestaProducto').innerHTML = html;
		}	
		return resultado;
	}
	
	
	function enviarPorAjax(datos){
		var data = new FormData();
		
		jQuery.each(datos.imagen, function(i, file) {
		    data.append("file", file);
		});
		data.append("code",datos.code);
		data.append("nombre",datos.nombre);
		data.append("descripcion",datos.descripcion);
		data.append("cantidad",datos.cantidad);
		data.append("precio",datos.precio);
		data.append("categoria",datos.categoria);
		
		$.ajax({
			url: 'recibeProducto.html',
			data: data,
		    cache: false,
		    contentType: false,
		    processData: false,
		    method: 'POST',
			success: function(result){
				if(result !== "error"){
	            	var productos = JSON.parse(result);
	            	var cuerpoDeLaTabla;
	            	paginacionDatos.ultimaPagina = Math.round(productos.length / NPRODUCTOS);
	            	html = '<div class="alert alert-dismissible alert-success">'  
						  +'Producto agregado correctamente' 
						  +'</div>';
	            	document.getElementById('respuestaProducto').innerHTML = html;
	            	setTimeout(
	    			  function() 
	    			  {
	    				  $('#formAdd')[0].reset();
	    				  document.getElementById('respuestaProducto').innerHTML = "";
	    			  }, 4000);//para que le de el tiempo al workspace de actualizar la carpeta de imagenes
	            	agregoItemALaPaginacion(productos.length);
				}else{
					html = '<div class="alert alert-dismissible alert-danger">'  
						  +'<strong>Error!</strong> <a class="alert-link">Complete todos los campos</a> por favor.' 
						  +'</div>';
					document.getElementById('respuestaProducto').innerHTML = html;
				}
			},
			error: function (data) {
				html = '<div class="alert alert-dismissible alert-danger">'  
					  +'Error al querer guardar el producto' 
					  +'</div>';
				document.getElementById('respuestaProducto').innerHTML = html;
            }
		})
		
		// esta linea es en el caso que estoy agregando producto y estaba la tabla vacia cosa que refresque la tabla
		paginacionDatos.ultimaPagina = (paginacionDatos.ultimaPagina == 0) ? 1 : paginacionDatos.ultimaPagina;

		// actualizo la pagina en la que me encuentro, con una demora para dar tiempo al guardado en la db
		if(paginacionDatos.ultimaPagina == paginacionDatos.paginaEnLaQueEstoy){
			setTimeout(function() {
				$("#resultadoDeMostrarProductos" ).empty();
				mostrarProductosEspecificos( paginacionDatos.paginaEnLaQueEstoy);
	    	}, 4000);
		}
	}

	
	function plantillaDeLaTabla(producto){
		const renglon = document.createElement('tr');
		renglon.classList.add('row-producto');
		
		const urlimg = document.createElement('td');
		urlimg.classList.add('align-middle');
		urlimg.classList.add('justify-content-center');
		const img = document.createElement('img');
		img.setAttribute("src",producto.urlimg);
		img.setAttribute("width",100);
		img.setAttribute("heighth",50);
		urlimg.appendChild(img);
		
		const id = document.createElement('td');
		id.classList.add('align-middle');
		id.innerHTML  = producto.id;
		
		const code = document.createElement('td');
		code.classList.add('align-middle');
		code.innerHTML  = producto.code;
		
		const nombre = document.createElement('td');
		nombre.classList.add('align-middle');
		nombre.innerHTML  = producto.nombre;
		
		const descripcion = document.createElement('td');
		descripcion.classList.add('align-middle');
		descripcion.innerHTML  = producto.descripcion;
		
		const cantidad = document.createElement('td');
		cantidad.classList.add('align-middle');
		cantidad.innerHTML  = producto.cantidad;
		
		const precio = document.createElement('td');
		precio.classList.add('align-middle');
		precio.innerHTML  = producto.precio;
		
		const categoria = document.createElement('td');
		categoria.classList.add('align-middle');
		categoria.innerHTML  = producto.categoria.nombre;
		
		const operacion = document.createElement('td');
		operacion.classList.add('align-middle','m-0');
		const btnContainer = document.createElement('div');
		btnContainer.classList.add('btn-group');
		btnContainer.setAttribute('role','group');
		const btnDelete = document.createElement('button');
		btnDelete.classList.add('btn','btn-danger', 'rounded','p-2','mb-0','btn-sm','eventStateDelete', 'btn-el','fas', 'fa-trash-alt');
		btnDelete.setAttribute('type','button');
		btnDelete.setAttribute('value',producto.id);		
		
		btnDelete.onclick = function(e) {
			  eliminarProducto(e);
		}
		
		btnContainer.appendChild(btnDelete);
		operacion.appendChild(btnContainer);
		
		renglon.appendChild(urlimg);
		renglon.appendChild(id);
		renglon.appendChild(code);
		renglon.appendChild(nombre);
		renglon.appendChild(descripcion);
		renglon.appendChild(cantidad);
		renglon.appendChild(precio);
		renglon.appendChild(categoria);
		renglon.appendChild(operacion);
		document.getElementById('resultadoDeMostrarProductos').appendChild(renglon);
	 }
	
	/**
	 *
	 * @Funciones from to pagination
	 * 
	 */
	
	function paginacionDeProductos(){
		  $.ajax({
			    url:'paginacion.html',
	            type: 'POST',	
	            success: function (data) {
	            	var productos = JSON.parse(data);
	            	paginacion(productos);
	            },
	            error: function (data) {
	                console.log(data.id + "error en la petición");
	            }
	        });
	}
	
	/**
	 * @details:  funcion que muestra la paginación de los productos
	 * 
	 */
	function paginacion(productos){	
		//tener de constante la ultima página
		paginacionDatos.ultimaPagina = Math.round( productos.total / productos.productosAmostrar);
//		console.log('paginacionDatos.ultimaPagina: ' + paginacionDatos.ultimaPagina);
		for(var i = 1 ; i <= Math.round(productos.total / productos.productosAmostrar) ; i++){
			const fila = document.createElement('li');
			fila.classList.add("page-item");
			fila.setAttribute("id", "fila-"+i);
			//if( i === 1)
			if( i === paginacionDatos.paginaEnLaQueEstoy) fila.classList.add("active");
			
			const button = document.createElement('button');
			button.classList.add("page-link");
			button.innerHTML = i;
			button.setAttribute("value", i);
			
			fila.appendChild(button);
			document.getElementById('paginacionProductos').appendChild(fila);
			
			button.onclick = function(e) {
				  mostrarProductosEspecificos(e.target.value);
			};
		}
	}
	
	
	/**
	 * @details:  muestra solo los productos de cierta pagina
	 * 
	 */
	function mostrarProductosEspecificos(e){
		var url = 'muestraProductos/'+e+'.html';
		paginacionDatos.paginaEnLaQueEstoy = e;
		$.ajax({
		    url: url,
            type: 'GET',	
            success: function (data) {
	            	var productos = JSON.parse(data);
	            	var cuerpoDeLaTabla;
	            
	            	$("#resultadoDeMostrarProductos" ).empty();
	            	productos.forEach(function(dato) {
	            		 plantillaDeLaTabla(dato);
	            	});
	            	
	            	//saco la clase active de todos los li
	            	$('#paginacionProductos li').each(function(index,element){        
	            		const indice = index + 1;
	            		//console.log('indice: '+indice);
	            		$('#fila-'+indice).removeClass("active");
	            	});          	
	            	// agrego la clase active al li correspondiente
	            	if( document.getElementById('fila-'+e)!== null) // hago esto por que me tiraba un error que no logre corregir
	            		document.getElementById('fila-'+e).classList.add("active");
            },
            error: function (data) {
                console.log(data + "error en la peticion");
            }
        });
		
		if( paginacionDatos.paginaEnLaQueEstoy > 1 || paginacionDatos.paginaEnLaQueEstoy < paginacionDatos.ultimaPagina){
    		$("#next-item").removeClass('disabled');
    		$("#previous-item").removeClass('disabled');
    	}
		
		if( paginacionDatos.paginaEnLaQueEstoy == 1){
    		$("#previous-item").addClass('disabled');
    	}
		
		if( paginacionDatos.paginaEnLaQueEstoy == paginacionDatos.ultimaPagina){
    		$("#next-item").addClass('disabled');
//    		console.log('entro')
    	}
	}
	
	
	/**
	 * @details:  cuando agrego un producto nuevo y exedo la cantidad permitida
	 * 			  por página
	 * 
	 */
	function agregoItemALaPaginacion(index){
		if( NPRODUCTOS == 1 || ( NPRODUCTOS > 1 && index % NPRODUCTOS != 0) ){
			index = (NPRODUCTOS == 1)? index : Math.round(index / NPRODUCTOS) ;
			const fila = document.createElement('li');
			fila.classList.add("page-item");
			fila.setAttribute("id", "fila-"+index);
	
			const button = document.createElement('button');
			button.classList.add("page-link");
			button.innerHTML = index;
			button.setAttribute("value", index);
			
			fila.appendChild(button);
			document.getElementById('paginacionProductos').appendChild(fila);
			
			button.onclick = function(e) {
				  mostrarProductosEspecificos(e.target.value);
			}
		}
	}
	
	/*
	 * Boton siguiente
	 */
	$('#next').click(function(e){
    	if( (paginacionDatos.paginaEnLaQueEstoy < paginacionDatos.ultimaPagina)){
    		var paginaAmostrar = 0;
    		paginaAmostrar = parseInt( paginacionDatos.paginaEnLaQueEstoy) + 1;
    		mostrarProductosEspecificos(paginaAmostrar);
    		if(paginacionDatos.paginaEnLaQueEstoy != 1)	$("#previous-item").removeClass('disabled');
    	} 	
    	if( paginacionDatos.paginaEnLaQueEstoy == paginacionDatos.ultimaPagina){
    		$("#next-item").addClass('disabled');
    	}
	});
	
	/*
	 * Boton anterior
	 */
	$('#previous').click(function(e){
    	if(paginacionDatos.paginaEnLaQueEstoy > 1){
    		paginacionDatos.paginaEnLaQueEstoy--;
    		mostrarProductosEspecificos(paginacionDatos.paginaEnLaQueEstoy);
    		if(paginacionDatos.paginaEnLaQueEstoy !=  paginacionDatos.ultimaPagina) $("#next-item").removeClass('disabled');
    	}
    	
    	if( paginacionDatos.paginaEnLaQueEstoy > 1 || paginacionDatos.paginaEnLaQueEstoy < paginacionDatos.ultimaPagina){
    		$("#next-item").removeClass('disabled');
    		$("#previous-item").removeClass('disabled');
    	}
    	
    	if( paginacionDatos.paginaEnLaQueEstoy == 1){
    		$("#previous-item").addClass('disabled');
    	}
	});
	
	/*
	 * Boton eliminar
	 */
	function eliminarProducto(e){
		var pagina = paginacionDatos.paginaEnLaQueEstoy;
		var url = 'eliminarProductoAJax/'+e.target.value+'/'+paginacionDatos.paginaEnLaQueEstoy+'.html';
		$.ajax({
		    url: url,
            type: 'GET',	
            success: function (response) {
            	var data = JSON.parse(response);
            	if(data.respuesta === "vacio"){
            		$("#resultadoDeMostrarProductos" ).empty();
            		$('#paginacionProductos').empty();	
            	}else{
            		pagina = data.indicePaginaActual;
            	}
            	
            },
            error: function (data) {
                console.log("error en la peticion");
            }
        });
		paginacionDatos.paginaEnLaQueEstoy = pagina == 0 ? 1 : pagina ;
		setTimeout(function() {
			$("#resultadoDeMostrarProductos" ).empty();
			mostrarProductosEspecificos( pagina );
			$('#paginacionProductos').empty();	
			paginacionDeProductos();
    	}, 1000);
	}
	mostrarProductos();
	paginacionDeProductos();
})

