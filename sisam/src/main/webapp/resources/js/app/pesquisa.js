/**
 * JavaScript referente ao formulário de pesquisa
 */
$(document).ready(function(){
	
	$('tbody').find('[data-tr-likert]').each(function(i,v){
		$(this).find(':hidden').attr('name', 'questoesRespondidas['+i+'].id');
		$(this).find(':radio').attr('name', 'questoesRespondidas['+i+'].opcao');
	});
	
	
	$('#form-resposta').submit(function(event){
		if(!validaPesquisa()) event.preventDefault();
	});
	
});

function validaPesquisa(){
	var validado = true;
	$('tbody').find('[data-tr-likert]').each(function(){
		if(!$(this).find(':radio:checked').length){
			var $tr = $(this);
			$tr.addClass('alert-danger').find(':radio')
				.on('change', function(){
				   $tr.removeClass('alert-danger');
				});
			validado = false;
		}
	});
	return validado;
}

