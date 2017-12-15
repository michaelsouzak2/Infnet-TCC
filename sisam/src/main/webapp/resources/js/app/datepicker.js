/**
 * JavaScript para tratamento de datas.
 */
var DATE_FORMAT = "dd/mm/yy";

$(document).ready(function(){
	startDatePicker();
	startDateRanger();
});

/**
 * Inicia a API datepicker do jQuery UI 
 * para os campos que possuem o data atributo especificado abaixo.
 */
function startDatePicker(){
	$('[data-datepicker]').datepicker($.datepicker.regional["pt-BR"]).datepicker("option", "dateFormat", DATE_FORMAT);
};

/**
 * Permite a seleção de intervalo de datas. 
 */
function startDateRanger(){
	var from = $('[data-datepicker="from"]').on( "change", function() {
		to.datepicker( "option", "minDate", getDate( this ) );
	}),
     to = $('[data-datepicker="to"]').on( "change", function() {
    	from.datepicker( "option", "maxDate", getDate( this ) );
	});
}

function getDate(element) {
	var date;
	try {
		date = $.datepicker.parseDate(DATE_FORMAT, element.value);
	} catch(error) {
		date = null;
	}
	return date;
}
