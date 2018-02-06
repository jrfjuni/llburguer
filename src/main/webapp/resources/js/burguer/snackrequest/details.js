var template_tr_table_person = "<tr>" +
                               "	<td width='20%'>[PERSON]</td>" +
                               "	<td width='40%'><input id='[ID_VALUE]' type='number' class='form-control burguer-person-value' [IDENTIFIER_VALUE]></td>" +
                               "	<td width='40%'><input id='[ID_PERCENT]' type='number' class='form-control burguer-person-percent' [IDENTIFIER_PERCENT]></td>" +
                               "<tr>";
                               

$(document).ready(function(){
	_createPercentPerson();
	
	$(document).off('keyup', '.burguer-person-value');
	$(document).on('keyup', '.burguer-person-value', _calculatorValue);
	
	$(document).off('keyup', '.burguer-person-percent');
	$(document).on('keyup', '.burguer-person-percent', _calculatorPercent);
	
	$(document).on('keyup', '#qtyPeople', _calculatorValuePerson)
	
});

function _calculatorPercent(){
	let percent = $(this).val();
	let percentPerson = $(this).attr('percentperson');
	let elementValue = $('#valuePerson_' + percentPerson);
	let valueOrder = $('#requestValueOrder').val();
	
	if(percent == '' || isNaN(percent) || parseInt(percent) <= 0)
		$(elementValue).val(0);
	else{
		let value = ( percent * valueOrder ) / 100;
		$(elementValue).val( parseFloat(value).toFixed(2));
	}
};

function _calculatorValue(){
	let value = $(this).val();
	let valuePerson = $(this).attr('valueperson');
	
	let elementPercent = $('#percentPerson_' + valuePerson);
	
	if(qty == '' || isNaN(qty) || parseInt(value) <= 0)
		$(elementPercent).val(0);
	else{
		
		
		
	}
	
};

function _calculatorValuePerson(){
	let valueOrder = $('#requestValueOrder').val();
	let valuePerson = parseFloat(0).toFixed(2);
	let qty = $(this).val();
	
		if(qty == '' || isNaN(qty) || parseInt(qty) <= 0)
			$('.burguer-value-person').html(parseFloat(0).toFixed(2));
		else{
			valuePerson = valueOrder / parseInt(qty);
			$('.burguer-value-person').html(parseFloat(valuePerson).toFixed(2));
		}
		
		_createPercentPerson();
};

function _createPercentPerson(){
	let qty = $("#qtyPeople").val();
	
	if(qty == '' || isNaN(qty) || parseInt(qty) <= 0){
		$('.burguer-table-person-percent').hide();
		$('.burguer-tbody-person-percent').html('');
	}
		
	else{
		
		let tr = '';
		for(var i = 1; i <= qty; i++){
			tr += template_tr_table_person.replace('[PERSON]', MESSAGE.person + " " + i)
				                          .replace('[ID_VALUE]', 'valuePerson_' + i)
				                          .replace('[IDENTIFIER_VALUE]', "valueperson='"+i+"'")
				                          .replace('[ID_PERCENT]', 'percentPerson_' + i)
				                          .replace('[IDENTIFIER_PERCENT]', "percentperson='"+i+"'")
		}
		
		$('.burguer-table-person-percent').show();
		$('.burguer-tbody-person-percent').html(tr);
	}
};