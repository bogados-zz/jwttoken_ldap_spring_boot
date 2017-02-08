var server = 'http://localhost:8080/api/encuesta';

$(document).ready(function () {
	
	$.ajax({
		url: server + '/pregunta',
		type: 'GET',
		success: function(data){
			$('.titulo-encuesta').text(data.mensaje);
			$('#idPregunta').val(data.id);
		},
		error: function(data){
			response = data.responseJSON;
			$('.titulo-encuesta').text(response.message);
			$('.m-t-lg').hide();
		}
	});
	
	$('.yes').on('click',function(){
		enviaRespuesta(true);
	});
	
	$('.no').on('click',function(){
		enviaRespuesta(false);
	});
    
});

function enviaRespuesta(respuesta){
	var idPregunta = $('#idPregunta').val();
	var data = {respuesta:respuesta, pregunta:{id:idPregunta}};
	/*var saludo = 'Gracias por colaborar';*/
	
	$.ajax({
		url: server + '/respuesta',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(data){
			$('.msg-saludo').text(data.message);
		},
		error: function(data){
			response = data.responseJSON;
			if(response.status == 403)
				$('.msg-saludo').text(response.message);
			else
				$('.msg-saludo').text(saludo);
		},
		complete: function(data){
			$('.pregunta').fadeOut(function(){
				$('.saludo').fadeIn();
				//setTimeout(function(){window.close();},1000);
			});
		}
	});
}