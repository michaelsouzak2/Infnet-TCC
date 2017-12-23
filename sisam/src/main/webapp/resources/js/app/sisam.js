/**
 * Script geral e comum a toda aplicação.
 */
$(document).ready(function(){
	focusFirstInput();
});

function focusFirstInput(){
	$(':input').not('disabled').not('readonly').first().focus();
}