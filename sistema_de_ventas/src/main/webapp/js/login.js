$(document).ready(function(){
	
	$("#login").click(function(){
		var usuario = $("#usuario").val();
		var password = $("#password").val();
		if(usuario!= "" && password != ""){
			var data = new FormData();
			data.append("usuario",usuario);
			data.append("password",password);
			$.ajax({
				url: 'loginVerificacion',
				method: 'POST',
				data: data,
				cache: false,
			    contentType: false,
			    processData: false,
				success: function(response){
					
					if(response === "vacio"){
						document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-danger'>"
							 + "<strong>Error! </strong> Hay campos vacios."
							 + "</div>";
					}else{
						if(response !== "error"){
							document.getElementById('respuestaLogin').innerHTML = "<div class='alert alert-dismissible alert-success'>"
								 + "<strong>Bienvenido! </strong> " + response 
								 + "</div>";
							setTimeout(function(){
								window.location.replace("admin");
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