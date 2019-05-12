$(document).ready(function(){
	$("#registrarCliente").click(function(){
		var datos = {
			email:  $("#email").val(),
		 	nombre: $("#nombre").val(),
		 	direccionCalle: $("#direccionCalle").val(),
		 	direccionAltura: $("#direccionAltura").val(),
		 	localidadNombre: $("#localidadNombre").val(),
		 	password: $("#passwordRegistro").val(),
		 	password2: $("#password2").val()
		}
				
		if(validacionCorrecta(datos) == 1 ){
			var data= new FormData();
			data.append("nombre",datos.nombre);
			data.append("email",datos.email);
			data.append("password",datos.password);
			data.append("password2",datos.password2);
			data.append("direccionCalle",datos.direccionCalle);
			data.append("direccionAltura",datos.direccionAltura);
			data.append("localidadNombre",datos.localidadNombre);
			
			$.ajax({
				url: 'registrarCliente',
				method: 'POST',
				data: data,
				cache: false,
			    contentType: false,
			    processData: false,
				success: function(response){
					var data = JSON.parse(response);
					switch(data.error){
						case 0:
							respuesta(data.respuesta,false);
							break;
						case 2:
							respuesta(data.respuesta,true);
							break;
						case 3:
							respuesta(data.respuesta,true);
							break;
						case 4:
							respuesta(data.respuesta,true);
							break;
						case 5:
							respuesta(data.respuesta,true);
							break;
						default:
							respuesta(data.respuesta,true);
							break;
					}
				},
				error: function(e){
					respuesta("Hubo problemas con su registro intente más tarde",true);
				}
			})
		}else if(validacionCorrecta(datos) == 3){
			respuesta("El email ingresado no es valido",true);
		}else if(validacionCorrecta(datos) == 4){
			respuesta("Las contrasenias no son iguales",true);
		}else{
			respuesta("complete todos los campos por favor",true);
		}
		
	})
	
	function validacionCorrecta(datos){
		var caract = new RegExp(/^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/);
		var respuesta = 1;
		if(datos.email == "" || datos.nombre == "" || datos.direccionCalle == "" || datos.direccionAltura == ""  
				|| datos.localidadNombre == "" || datos.password == "" || datos.password2 == ""){
			respuesta = 2;
		}else if(!caract.test($("#email").val())){
			respuesta = 3;
		}else if(datos.password !== datos.password2){
			respuesta = 4;
		}
		return respuesta;
	}
	
	function respuesta(msj,error){
		if(error)
			document.getElementById('respuestaRegistro').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
				 + msj
				 + "</div>";
		else
			document.getElementById('respuestaRegistro').innerHTML = "<div class='alert alert-dismissible alert-success'>"
				 + msj
				 + "</div>";
	}
})