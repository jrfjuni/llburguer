package br.com.entelgy.burguer.controller.snackrequest;

import javax.validation.constraints.Size;

import br.com.entelgy.burguer.comuns.validators.Required;

public class FormSnackRequest {

	@Required
	@Size(max=75)
	private String name;
	
	@Required
	@Size(max=100)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}