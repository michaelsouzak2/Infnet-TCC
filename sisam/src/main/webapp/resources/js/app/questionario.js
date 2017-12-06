/**
 * Script da funcionalidade Questionário.
 */
var CONT_QUESTOES = 0

$(document).ready(function(){
	
	/*$('#form-novo-questionario').submit(function(){
		$(this).find('[data-chk-questao]').each(function(){
			var $clicked = $(this);
			if($clicked.is(':checked')){
				$('#questoes-selecionadas').append('<input type="hidden" name="questoes['+CONT_QUESTOES+'].id" value="'+$clicked.val()+'" />');
				CONT_QUESTOES++;
			}
		});
	});

	$('[data-chk-topico]').change(function(){
		var $panelTopico = $(this);
		var $panelQuestoes = $('#'+$panelTopico.attr('data-chk-topico'));
		$panelQuestoes.find('[data-chk-questao]').each(function(){
			$(this).prop("checked", ($panelTopico.is(':checked')? true : false));
		});
	});*/
	
});