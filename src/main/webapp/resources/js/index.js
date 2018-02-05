$(document).ready(function(){
	
//	$(document).off('click', '.burguer-btn-login');
//	$(document).on('click', '.burguer-btn-login', _fnClickLogin);
	
	
});

function _fnClickLogin(){
	$.ajax({
		url: "http://localhost:8080/burguer/login",
		type:'POST',
        dataType:'json',
		data: $('#loginForm').serialize(),
		success: function(result) {
			
			
			
		}
	});		
};