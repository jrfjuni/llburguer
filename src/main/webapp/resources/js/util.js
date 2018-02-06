$(document).ready(function(){

	$(document).off('click', '.burguer-btn-logout')
	$(document).on('click', '.burguer-btn-logout', function(){
		window.location.href = contextPath + "/logout";
	});
	
	fnScrollTop = function(){
		 $('html, body').animate({
			 scrollTop: $("body").offset().top
		 }, 1000);
	};
	
	fnShowMessaError = function(message){
		fnCleanFieldsInvalid();
		
		$('.burguer-message').addClass("alert alert-danger").html(message);
	};
	
	fnShowFieldsInvalid = function(fields){
		fnCleanFieldsInvalid();
		
		fields.forEach(function(value){
			
			var field = value.field;
			var message = value.message;
			
			if(field.lastIndexOf('#', 0) == 0)
				$fieldEl = $(field);
			else
				$fieldEl = $('#' + field);
			
			$fieldEl.attr('name', field);
			
			$parent = $fieldEl.parent();
			$('<em for="' + $fieldEl.attr('name') + '" class="invalid burguer-field-invalid">' + message + '</em>').insertAfter($parent);
		});
	};
	
	fnCleanFieldsInvalid = function(){
		$('.burguer-field-invalid').remove();
		$('.burguer-message').removeClass("alert alert-danger").html('');
	};
	
	fnFillCombo = function(element, options){
		
		var option = "<option value=''></option>";
		options.forEach(function(value){
			option += "<option value='"+value.id+"'>"+value.description+"</option>";
		});
		
		$(element).html(option);
	};
	
	fnSetLang = function(lang){
		window.location.href = contextPath + "/?lang=" + lang;
	
	};
});