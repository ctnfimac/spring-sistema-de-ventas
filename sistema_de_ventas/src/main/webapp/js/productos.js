
$(document).ready(function(){



	
	/*
	 * mostrarProductos()
	 * recibiendo y mostrando los productos de la base de datos
	 * 
	 */
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
	            },
	            error: function (data) {
	                console.log(data.id + "error en la petición");
	            }
	        });
	}
	
	
	/*
	 * Agregar productos
	 * 
	 */
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

	mostrarProductos();
})

