package com.controller.ThongKe;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.ChucVu;
import com.model.NhanVien;
import com.model.ThongKeBenhAn;
import com.model.DAO.ChucVu.ChucVuJDBC;
import com.model.DAO.NhanVien.NhanVienJDBC;
import com.model.DAO.ThongKeBenhAn.ThongKeBenhAnJDBC;

@Controller
@RequestMapping(value="/thong-ke")
public class ThongKeController {
	private ApplicationContext context;

	@RequestMapping(value = "/benh-an", method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhAnJDBC thongkeJDBC = (ThongKeBenhAnJDBC) context.getBean("thongKeBenhAnJDBC");						
		List<ThongKeBenhAn> benhAnList = thongkeJDBC.getList();		
		model.addAttribute("benhAnList",benhAnList);
		return "thongkebenhan";
	}
	
	
	
}
