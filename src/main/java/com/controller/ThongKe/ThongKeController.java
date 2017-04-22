package com.controller.ThongKe;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public String getListTKBenhAn(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhAnJDBC thongkeJDBC = (ThongKeBenhAnJDBC) context.getBean("thongKeBenhAnJDBC");						
		List<ThongKeBenhAn> benhAnList = thongkeJDBC.getList();		
		model.addAttribute("benhAnList",benhAnList);
		return "thongkebenhan";
	}
	
	@RequestMapping(value = "/benh-an", method = RequestMethod.POST)
	public String getListTKBenhAnByDate(HttpServletRequest request, ModelMap model) throws ParseException {		
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhAnJDBC thongkeJDBC = (ThongKeBenhAnJDBC) context.getBean("thongKeBenhAnJDBC");
		List<ThongKeBenhAn> benhAnList;
		String date = request.getParameter("dateThongKeBenhAn");
		if (date != null && !"".equals(date)) {
			int arrLength = date.split("/").length;
			if(arrLength==1) benhAnList = thongkeJDBC.getByYear(Integer.parseInt(date));
			if(arrLength==2) benhAnList = thongkeJDBC.getByMonth(Integer.parseInt(date.split("/")[0]), Integer.parseInt(date.split("/")[1]));
			if(arrLength==3){				
				Date dateResult = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				String dateString = new SimpleDateFormat("yyyy-MM-dd").format(dateResult);
				System.out.println(dateString);
				benhAnList = thongkeJDBC.getByDate(dateString); 
			}
			else benhAnList = thongkeJDBC.getList();
			System.out.println(arrLength);
		} else {
			benhAnList = thongkeJDBC.getList();
		}
		model.addAttribute("benhAnList",benhAnList);
		return "thongkebenhan";
	}
	
}
