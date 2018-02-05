package br.com.entelgy.burguer.entity.vo;

import org.springframework.security.core.GrantedAuthority;

public class RoleVO implements GrantedAuthority {
	
	private static final long serialVersionUID = -963217709584638854L;
	
	private String role;
	
	public RoleVO(){}
	
	public RoleVO(String role) {
		this.role = role;
	}

	public String getAuthority() {
		return this.role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}