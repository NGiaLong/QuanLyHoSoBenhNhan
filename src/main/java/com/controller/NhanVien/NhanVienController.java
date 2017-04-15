package com.controller.NhanVien;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.DAO.NhanVien.NhanVienJDBC;
import com.model.*;

@Controller
public class NhanVienController {
	private ApplicationContext context;
	
	@RequestMapping(value="/quanlynhanvien",method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		System.out.println("1111111111111111111111111");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		NhanVienJDBC nhanVienJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
		List<NhanVien> nVList = nhanVienJDBC.getAll();
		model.addAttribute("nVList", nVList);
		return "quanlynhanvien";
	}
}
