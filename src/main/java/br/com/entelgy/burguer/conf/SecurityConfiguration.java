package br.com.entelgy.burguer.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.entelgy.burguer.service.LoginService;

/**
 * <p> Classe responsável em realizar as configurações de segurança da aplicação
 * @author Junnior
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoginService loginService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/snackrequest/**").hasRole("CLIENT")
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/")
			.usernameParameter("username").passwordParameter("password")
			.defaultSuccessUrl("/snackrequest/index")
			.permitAll()
			.and().csrf().disable();
	}
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
