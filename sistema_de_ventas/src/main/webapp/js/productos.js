
$(document).ready(function(){
	//const NPRODUCTOS = 2; // este valor tambien esta en ProductoController
	
	
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
	            	productos.forEach(function(dato) {
	            		cuerpoDeLaTabla += plantillaDeLaTabla(dato);
	            	});
	            	$('#resultadoDeMostrarProductos').html(cuerpoDeLaTabla);
	            	paginacion(productos);
	            },
	            error: function (data) {
	                console.log(data.id + "error en la petición");
	            }
	        });
		  paginacionDeProductos()
	}
	
	
	/*
	 * Agregar productos
	 * 
	 * */
	$('#btnAddProducto').click(function(e){
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
	});
	
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
            	var productos = JSON.parse(result);
            	var cuerpoDeLaTabla;
            	productos.forEach(function(result) {
            		cuerpoDeLaTabla += plantillaDeLaTabla(result);
            	});
            	setTimeout(
    			  function() 
    			  {
    				  $('#resultadoDeMostrarProductos').html(cuerpoDeLaTabla);//actualizo la informacion de la tabla
    				  $('#formAdd')[0].reset();
    			  }, 4000);//para que le de el tiempo al workspace de actualizar la carpeta de imagenes
			}
		})
		 
	}

	
	function plantillaDeLaTabla(producto){
		var fila = "<tr>" +
						"<td class='align-middle justify-content-center'><img src='"+producto.urlimg+"' width=125></td>"+
						"<td class='align-middle'>"+producto.id+"</td>" +
						"<td class='align-middle'>"+producto.code+"</td>" +
						"<td class='align-middle'>"+producto.nombre+"</td>" +
						"<td class='align-middle'>"+producto.descripcion+"</td>" +
						"<td class='align-middle'>"+producto.cantidad+"</td>" +
						"<td class='align-middle'>"+producto.precio+"</td>" +
						"<td class='align-middle'>"+producto.categoria.nombre+"</td>" +
						"<td class='align-middle m-0'>"+
				         	"<div class='btn-group' role='group'>"+
				         		"<button type='button' value='"+producto.id+"' class='btn btn-danger btn-sm eventStateDelete'><i class='fas fa-trash-alt'></i></button>"+		                 		
								"<button type='button' value='"+producto.id+"' class='btn btn-warning btn-sm eventEstado'><i class='fas fa-pencil-alt'></i></button>"+
				         	"</div>"+
				        "</td>"+
					"</tr>";
		return fila;
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
	            	paginacion(productos)
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
		var paginas = "<nav aria-label='Page navigation example'>"+
			"<ul class='pagination pagination-circle pg-blue justify-content-center'>"+
				"<li class='page-item disabled'>"+
					"<a class='page-link' tabindex='-1'>Previous</a>"+
				"</li>";
		for(var i = 1 ; i <= productos.total / productos.productosAmostrar ; i++){
			paginas += ( i === 1)? 
					"<li class='page-item active'><a class='page-link'>"+i+"</a></li>"
					:
					"<li class='page-item'><a class='page-link'>"+i+"</a></li>"
		}
		
		paginas += "<li class='page-item'>"+ 
				   		"<a class='page-link'>Next</a>"+
				   "</li>"+
			  "</ul>"+
			"</nav>";
		$('#paginacionProductos').html(paginas);
	}

	mostrarProductos();
	paginacionDeProductos();
})

