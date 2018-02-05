package br.com.entelgy.burguer.controller;

import javax.validation.constraints.Size;

import br.com.entelgy.burguer.comuns.validators.Required;

public class FormLogin {
	
	@Required
	@Size(min=6, max=75)
	private String username;
	
	@Required
	@Size(min=6, max=15)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}