package com.fpt.controller.Login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private ApplicationContext context;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		System.out.println("Hello");
		return "login";
		
	}
}
