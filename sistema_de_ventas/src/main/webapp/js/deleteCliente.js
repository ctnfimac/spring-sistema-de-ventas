$(document).ready(function(){
	$('.eventStateDelete').click(function(e){
		enviarPorAjax(e.target.value);
	})
	
	function enviarPorAjax(id){
		$.ajax({
			url: 'eliminacionCliente.html',
			type: 'GET',
			data: {id: id},
			success: function(data){
				$("#cliente"+id).remove();
			} 
		})
	}
})