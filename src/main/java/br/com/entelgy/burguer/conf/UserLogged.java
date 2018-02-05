package br.com.entelgy.burguer.conf;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.entelgy.burguer.entity.vo.UserLoggedVO;

public class UserLogged {
	
	private static UserLoggedVO user;
	
	public static UserLoggedVO getUsetLogged() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 getUser().setEmail(auth.getName());
		 return user;
	}
	
	private static UserLoggedVO getUser() {
		if(user == null)
			user = new UserLoggedVO();
		
		return user;
	}
}