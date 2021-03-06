$(document).ready(function(){
	
	$("#login").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		
		if(email!= "" && password != ""){
			var data = new FormData();
			console.log('email: ' + email)
			data.append("email",email);
			data.append("password",password);
			console.log('data: ' + data.email)
			console.log('data: ' + data.password)
			$.ajax({
				url: 'loginVerificacion',
				method: 'POST',
				data: data,
				cache: false,
			    contentType: false,
			    processData: false,
				success: function(response){
					var usuario = JSON.parse(response)
					console.log('nombre respuesta: ' + usuario.nombre)
					if(usuario.respuesta === "vacio"){
						document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
							 + "<strong>Error! </strong> Hay campos vacios."
							 + "</div>";
					}else{
						if(usuario.respuesta !== "error" && usuario.rol == "user"){
							document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-success'>"
								 + "<strong>Bienvenido! </strong> " + usuario.nombre 
								 + "</div>";
							setTimeout(function(){
								window.location.replace("cliente");
							},2000);
						}else{
							document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
								 + "<strong>Error! </strong> Usuario inexistente"
								 + "</div>";
						}
					}					
				},
				error: function(e){
					document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
						 + "<strong>Error! </strong> problemas con la comunicacion"
						 + "</div>";
				}
			});
		}else{
			document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
					 + "<strong>Error! </strong> Hay campos vacios."
					 + "</div>";
		}
	})
	
	
});