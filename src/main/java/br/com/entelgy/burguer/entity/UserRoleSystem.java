package br.com.entelgy.burguer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE_SYSTEM")
public class UserRoleSystem {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_system", nullable = false)
	private UserSystem user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role_system", nullable = false)
	private RolesSystem role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserSystem getUser() {
		return user;
	}

	public void setUser(UserSystem user) {
		this.user = user;
	}

	public RolesSystem getRole() {
		return role;
	}

	public void setRole(RolesSystem role) {
		this.role = role;
	}
	
	

}
