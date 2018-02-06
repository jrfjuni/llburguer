package br.com.entelgy.burguer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_SYSTEM")
public class UserSystem {

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRoleSystem> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRoleSystem> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoleSystem> roles) {
		this.roles = roles;
	}
}