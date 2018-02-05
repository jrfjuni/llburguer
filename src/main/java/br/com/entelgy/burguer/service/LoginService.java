package br.com.entelgy.burguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.entelgy.burguer.dao.LoginDAO;

@Service
public class LoginService implements ILoginService, UserDetailsService {
	
	@Autowired
	private LoginDAO loginDAO;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails user = getLoginDAO().loadUserByUsername(email);
		
			if(user == null)
				throw new UsernameNotFoundException("erro");
		
		return user;
	}
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}
}