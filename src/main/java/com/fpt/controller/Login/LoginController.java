package com.controller.Login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.NhanVien;
import com.model.DAO.NhanVien.NhanVienJDBC;

@Controller
public class LoginController {
	private ApplicationContext context;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(ModelMap model,HttpServletRequest request) {
		return "login";	
	}
}
