package br.com.entelgy.burguer.entity.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.entelgy.burguer.entity.User;
import br.com.entelgy.burguer.entity.UserRole;

public class UserVO implements UserDetails{
	
	private static final long serialVersionUID = 8833899420302604653L;

	private List<RoleVO> roles;
	
	private String userName;
	
	private String password;
	
	public UserVO() {}
	
	public UserVO(User client) {
		if(client != null) {
			
			this.userName = client.getEmail();
			this.password = client.getPassword();
			this.roles = new ArrayList<RoleVO>();
			
			for (UserRole role : client.getRoles()) {
				this.roles.add(new RoleVO(role.getRole().getRole()));
			}
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.userName;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}