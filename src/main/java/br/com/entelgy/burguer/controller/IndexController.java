package br.com.entelgy.burguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.entelgy.burguer.service.ILoginService;

@Controller
public class IndexController {

	@Autowired
	private ILoginService userService;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	public ILoginService getUserService() {
		return userService;
	}
}