/**
 * Script para tratamento de máscara.
 */
$(document).ready(function(){
	maskInput();
});

function maskInput(){
	$('[data-datepicker]').mask("00/00/0000", {placeholder: "  /  /    "});
}