/**
 * Script para tratamento de máscara.
 */
$(document).ready(function(){
	maskInput();
});

function maskInput(){
	$('[data-date]').mask("00/00/0000", {placeholder: "  /  /    "});
}