/**
 * Script da funcionalidade Questionário.
 */
var CONT_QUESTOES = 0

$(document).ready(function(){
	
	$('#grupos-atuais').children().each(function(){
		$('[data-chk-grupo]').filter('[value='+ $(this).val() +']').prop('checked', true);
	});
	
	$('#form-novo-questionario, #form-altera-questionario').submit(function(){
		$(this).find('[data-chk-grupo]').each(function(){
			var $clicked = $(this);
			if($clicked.is(':checked')){
				$('#grupos-selecionados').append('<input type="hidden" name="gruposQuestoes['+CONT_QUESTOES+'].id" value="'+$clicked.val()+'" />');
				CONT_QUESTOES++;
			}
		});
	});

});