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
			}
		})
	}
})