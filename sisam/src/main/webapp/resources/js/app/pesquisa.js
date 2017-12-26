/**
 * JavaScript referente ao formulário de pesquisa
 */
$(document).ready(function(){
	
	$('tbody').find('[data-tr-likert]').each(function(i,v){
		$(this).find(':hidden').attr('name', 'questoesRespondidas['+i+'].id');
		$(this).find(':radio').attr('name', 'questoesRespondidas['+i+'].opcao');
	});
	
	
	$('#form-resposta').submit(function(e){
		$('tbody').find('[data-tr-likert]').each(function(){
			if(!$(this).find(':radio:checked').length){
				var $tr = $(this);
				$tr.css('background-color', '#a94442')
					.find(':radio').on('change', function(){
						$tr.css('background-color', '');
					});
				
				e.preventdefault();
			}
		});
	});
	
});

