$(document).ready(function(){
	
	_init();
	
	$(document).off('click', '.btn-burguer-save');
	$(document).on('click', '.btn-burguer-save', _fnClickSave);
	
	$(document).off('click', '.btn-burguer-finish');
	$(document).on('click', '.btn-burguer-finish', _fnClickFinish);
	
	$(document).off('change', '#snack');
	$(document).on('change', '#snack', _fnChangeSnack);
	
	$(document).off('change', '.burguer-item-selected');
	$(document).on('change', '.burguer-item-selected', _fnRecalculateValueSnack);
	
	$(document).off('change', '.burguer-double-cheese');
	$(document).on('click', '.burguer-double-cheese', _fnRecalculateValueSnack);
	
	$(document).off('change', '.burguer-double-filling');
	$(document).on('click', '.burguer-double-filling', _fnRecalculateValueSnack);
	
});

function _fnClickFinish(){
	
	$.ajax({
		url: "/burguer/snackrequest/finish",
		type:'POST',
        dataType:'json',
		data: {name: $('#name').val(), address: $('#address').val()},
		success: function(result) {
			
			if(!result.success){
				
				fnScrollTop();
				
				if(result.fieldsError.length > 0)
					fnShowFieldsInvalid(result.fieldsError);
				else
					fnShowMessaError(result.message);
			}else{
				window.location.href = "/burguer/snackrequest/details/" + result.extraData.id;
			}
		}
	});		
	
}

function _fnClickSave(){
	fnCleanFieldsInvalid();
	
	$.ajax({
		url: "/burguer/snackrequest/save",
		type:'POST',
        dataType:'json',
		data: _getForm(),
		success: function(result) {
			
			fnScrollTop();
			
			if(result.success){
				let bread   = $('#bread option:selected').text();
				let cheese  = $('#cheese option:selected').text();
				let filling = $('#filling option:selected').text();
				
				let count = parseInt($('.burguer-list-snackes').attr('count')) + 1;
				$('.burguer-list-snackes').attr('count', count);
				
				let details = "<p class='list-group-item'>" + count + ' - ' + bread + "</p>";
				
				$(details).insertBefore('.burguer-list-snackes-order');
				
				let valueOrder = $('.burguer-value-order').html();
				let valueSnack = $('.burguer-value-snack').html();
				
				let value = parseFloat(valueOrder) + parseFloat(valueSnack);
				 $('.burguer-value-order').html(parseFloat(value).toFixed(2));
				
				_cleanFormSave();
				
			}else			
				fnShowFieldsInvalid(result.fieldsError);
			
		}
	});		
};

function _cleanFormSave(){
	$('.burguer-clean-save').each(function(){
		$(this).val('').attr('disabled', false);
	});
	
	$("#doubleCheese").prop('checked', false);
	$("#doubleFilling").prop('checked', false);
	$('.burguer-description-filling').html('');
	_fnRecalculateValueSnack();
};

function _fnFinish(){
	
};

function _getForm(){
	return {
		name: $('#name').val(),
		address: $('#address').val(),
		snack:  $('#snack').val(),
		bread: $('#bread').val(),
		cheese: $('#cheese').val(),
		doubleCheese: $('#doubleCheese').is(':checked'),
		filling: $('#filling').val(),
		doubleFilling: $('#doubleFilling').is(':checked')
	};
};

function _init(){
	$.ajax({
		url: "/burguer/comum/allProducts",
		 type:'GET',
         dataType:'json',
		success: function(result) {
			_fnFillComboProduct(result.extraData.snack, $('#snack'));
			_fnFillComboProduct(result.extraData.bread, $('#bread'));
			_fnFillComboProduct(result.extraData.cheese, $('#cheese'));
			_fnFillComboProduct(result.extraData.filling, $('#filling'));
			_fnRecalculateValueSnack();
		}
	});		
};

function _fnChangeSnack(){
	let id = $(this).val();
	
	if(id)
		_fillSnackSelected(id);
	else
		_fnCleanItensSnack();
	
};

function _fnCleanItensSnack(){
	_fnDisabledItensAssociateSnack(false, true);
	$('.burguer-description-filling').html('');
	_fnRecalculateValueSnack();
};

function _fillSnackSelected(id){
	$.ajax({
		url: "/burguer/comum/snack",
		type:'GET',
        dataType:'json',
        data: {id: id},
		success: function(result) {
			
			let idBread = result.idBread;
			let idCheese = result.idCheese;
			let idFilling = result.idFilling;
			let valueFilling = result.customFieldValueFilling;
			
			$('#bread').val(idBread);
			$('#cheese').val(idCheese);
			$('#filling').val(idFilling);
			$('.burguer-description-filling').html(valueFilling);
			
			_fnDisabledItensAssociateSnack(true, false);
			_fnRecalculateValueSnack();
		}
	});		
};

function _fnDisabledItensAssociateSnack(boolDisabled, clean){
	$('.burguer-associate-snack').each(function(){
		$(this).attr('disabled', boolDisabled);
		
		if(clean)
			$(this).val('');
	});
};



function _fnRecalculateValueSnack(){
	let valueOrder = 0;
	
	$('.burguer-recalculate').each(function(){
		let value = $(this).find(':selected').attr('price');
		
		if(value)
			valueOrder = valueOrder + parseFloat(value);
	});
	
	let isCheckedDoubleCheese  = $('.burguer-double-cheese').is(':checked');
	let isCheckedDoubleFilling = $('.burguer-double-filling').is(':checked');
	
	let priceTypeCheeseSelected = $('#cheese').find(':selected').attr('price');
	let priceTypeFillingSelected = $('#filling').find(':selected').attr('price');
	
	valueOrder += _fnGetValueDoble(isCheckedDoubleCheese, priceTypeCheeseSelected, $('.burguer-double-cheese'));
	valueOrder += _fnGetValueDoble(isCheckedDoubleFilling, priceTypeFillingSelected, $('.burguer-double-filling'));
	
	$('.burguer-value-snack').html( parseFloat(valueOrder).toFixed(2)  );
};

function _fnGetValueDoble(isCheckedDouble, price, element){
	let value = parseFloat(0);
	
	if(price){
		
		if(isCheckedDouble)
			value = parseFloat(price);
		
	}else
		$(element).prop('checked', false);
	
	return value;
};


function _fnFillComboProduct(products, element){
	
	let options = '<option value=""></option>';
	products.forEach(function(product){
		options += "<option value='"+product.id+"' price='"+product.numeric+"'>" + product.value + "</option>";
	});

	$(element).html(options);
}; 

