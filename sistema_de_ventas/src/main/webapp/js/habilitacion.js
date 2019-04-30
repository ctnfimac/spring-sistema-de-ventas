$(document).ready(function(){
	$(".eventEstado").click(function(e){
		enviarPorAjax(e.target.value);
	});
	
	function enviarPorAjax(id){
		$.ajax({
			url: 'habilitacionDeCliente.html',
			type: 'GET',
			data: {id: id},
			success: function(result){
				$('#clienteEstado'+id).html(result);
				//cambio el texto del boton y modifico su estilo
				var botones = document.getElementsByClassName('btn-habilitacion');
				
				for(i=0; i < botones.length ; i++){
					if(botones[i].value == id && result == "enabled"){
						botones[i].classList.remove("btn-success");
						botones[i].classList.add("btn-warning");
						botones[i].innerHTML = "disable"
					}else if (botones[i].value == id && result == "disabled"){
						botones[i].classList.remove("btn-warning");
						botones[i].classList.add("btn-success");
						botones[i].innerHTML = "enable"
					}
				}
			}
		})
	}
})