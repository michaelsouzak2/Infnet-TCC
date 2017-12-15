/**
 * Script da funcionalidade de avaliação
 */
var SELECT_TURMAS = {};
$(document).ready(function(){
	$('#turmas').change(function(){
		var $turma = $(this);
		var id = $turma.val();
		var $option = $turma.find('option:selected');
		var descricao = $option.text();
		var template = "<span data-turma-id="+id+">"+descricao+"<a onclick='removeTurma("+id+")'><i class='fa fa-times cursor-pointer'></i></a>&nbsp;</span>";
		$('#turmas-selecionadas').append(template);
		
		SELECT_TURMAS[id]=$turma.find('option:selected')[0].outerHTML;	
		$option.remove();
	});
	
	$('#form-nova-avaliacao').submit(function(){
		var $form = $('#form-nova-avaliacao');ui/i18n/datepicker-pt-BR.js
		$('#turmas-selecionadas').find('span').each(function(i,value){
			var id = value.getAttribute('data-turma-id');
			$form.append("<input type='hidden' name='turmas["+i+"].id' value="+id+" />");
		});
	});
	
});

function removeTurma(id){
	var $turmas = $('#turmas');
	$("[data-turma-id="+id+"]").remove();
	$turmas.append(SELECT_TURMAS[id]);
	delete SELECT_TURMAS[id];
	
	var $options = $turmas.children().get().sort(function(a, b){return a.value-b.value});
	$turmas.children().remove();
	$turmas.append($options).val(0);
}
