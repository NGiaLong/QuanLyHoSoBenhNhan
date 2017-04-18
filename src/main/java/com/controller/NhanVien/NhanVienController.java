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
@RequestMapping(value="/nhan-vien")
public class NhanVienController {
	private ApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET)
	public String quanLyNhanVien(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		NhanVienJDBC nhanVienJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
		List<NhanVien> nVList = nhanVienJDBC.getAllActive();
		model.addAttribute("nVList", nVList);
		return "quanlynhanvien";
	}
	@RequestMapping(value="/ngung-hoat-dong",method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		NhanVienJDBC nhanVienJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
		List<NhanVien> nVList = nhanVienJDBC.getAllDeActive();
		model.addAttribute("nVList", nVList);
		return "nhanvienngunghoatdong";
	}
}
