const NPRODUCTOS = 2;
paginacionDatos = {
		"paginaEnLaQueEstoy" : 1//,
		//"ultimaPagina" : 1
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
	            	productos.forEach(function(dato) {
	            		cuerpoDeLaTabla += plantillaDeLaTabla(dato);
	            	});
	            	$('#resultadoDeMostrarProductos').html(cuerpoDeLaTabla);
//	            	paginacionDeProductos()
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
    				  $('#formAdd')[0].reset();
    				  agregoItemALaPaginacion(productos.length);
    			  }, 4000);//para que le de el tiempo al workspace de actualizar la carpeta de imagenes
			}
		})
		// actualizo la pagina en la que me encuentro, con una demora para dar tiempo al guardado en la db
		setTimeout(function() {
			mostrarProductosEspecificos( paginacionDatos.paginaEnLaQueEstoy);
    	}, 2000);
	}

	
	function plantillaDeLaTabla(producto){
		var fila = "<tr>" +
						"<td class='align-middle justify-content-center'><img src='"+producto.urlimg+"' width=100 heigth=50></td>"+
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
//		paginacionDatos.ultimaPagina = Math.round( productos.total / productos.productosAmostrar);
		
		for(var i = 1 ; i <= Math.round(productos.total / productos.productosAmostrar) ; i++){
			const fila = document.createElement('li');
			fila.classList.add("page-item");
			fila.setAttribute("id", "fila-"+i);
			if( i === 1) fila.classList.add("active");
			
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
            
            	productos.forEach(function(dato) {
            		cuerpoDeLaTabla += plantillaDeLaTabla(dato);
            	});
            	$('#resultadoDeMostrarProductos').html(cuerpoDeLaTabla);
            	
            	//saco la clase active de todos los li
            	$('#paginacionProductos li').each(function(index,element){        
            		const indice = index + 1;
            		//console.log('indice: '+indice);
            		$('#fila-'+indice).removeClass("active");
            	});          	
            	// agrego la clase active al li correspondiente
            	document.getElementById('fila-'+e/*.target.value*/).classList.add("active");
            },
            error: function (data) {
                console.log(data + "error en la peticion");
            }
        });
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

	mostrarProductos();
	paginacionDeProductos();
})

