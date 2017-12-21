/**
 * JavaScript referente ao formulário de avaliação
 */
$(document).ready(function(){
	
	$('tbody').find('[data-tr-likert]').each(function(i,v){
		$(this).find(':hidden').attr('name', 'questoesRespondidas['+i+'].id');
		$(this).find(':radio').attr('name', 'questoesRespondidas['+i+'].opcao');
	});
	
});