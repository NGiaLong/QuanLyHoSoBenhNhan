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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.BenhAn;
import com.model.BenhNhan;
import com.model.ChucVu;
import com.model.NhanVien;
import com.model.ThongKeBenhAn;
import com.model.DAO.BenhAn.BenhAnJDBC;
import com.model.DAO.BenhNhan.BenhNhanJDBC;
import com.model.DAO.ChucVu.ChucVuJDBC;
import com.model.DAO.NhanVien.NhanVienJDBC;
import com.model.DAO.ThongKeBenhAn.ThongKeBenhAnJDBC;
import com.model.DAO.ThongKeBenhNhan.ThongKeBenhNhanJDBC;

@Controller
@RequestMapping(value = "/thong-ke")
public class ThongKeController {
	private ApplicationContext context;

	@RequestMapping(value = "/benh-an", method = RequestMethod.GET)
	public String getListTKBenhAn(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhAnJDBC thongkeJDBC = (ThongKeBenhAnJDBC) context.getBean("thongKeBenhAnJDBC");
		List<ThongKeBenhAn> benhAnList = thongkeJDBC.getList();
		model.addAttribute("benhAnList", benhAnList);
		model.addAttribute("tongSo", benhAnList.size());
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
			switch (arrLength) {
			case 1:
				benhAnList = thongkeJDBC.getByYear(Integer.parseInt(date));
				break;
			case 2:
				benhAnList = thongkeJDBC.getByMonth(Integer.parseInt(date.split("/")[0]),
						Integer.parseInt(date.split("/")[1]));
				break;
			case 3:
				Date dateResult = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				String dateString = new SimpleDateFormat("yyyy-MM-dd").format(dateResult);
				System.out.println(dateString);
				benhAnList = thongkeJDBC.getByDate(dateString);
				break;
			default:
				benhAnList = thongkeJDBC.getList();
			}
		} else {
			benhAnList = thongkeJDBC.getList();
		}
		model.addAttribute("benhAnList", benhAnList);
		model.addAttribute("tongSo", benhAnList.size());
		return "thongkebenhan";
	}

	@RequestMapping(value = "/benh-an/{maBA}", method = RequestMethod.GET)
	public String getChiTietByMaBA(@PathVariable String maBA, ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAttrs) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BenhAnJDBC benhAnJDBC = (BenhAnJDBC) context.getBean("benhAnJDBC");
		BenhAn benhAn = benhAnJDBC.getOne(maBA);
		BenhNhanJDBC benhNhanJDBC = (BenhNhanJDBC) context.getBean("benhNhanJDBC");
		BenhNhan benhNhan = benhNhanJDBC.getOne(benhAn.getMaBenhNhan());
		NhanVienJDBC nhanVienJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
		NhanVien nhanVien = nhanVienJDBC.getNVByMaNV(benhAn.getMaNhanVienKham());

		model.addAttribute("benhAn", benhAn);
		model.addAttribute("benhNhan", benhNhan);
		model.addAttribute("nhanVien", nhanVien);
		return "chitietbenhan";
	}

	@RequestMapping(value = "/benh-nhan", method = RequestMethod.GET)
	public String getListTKBenhNhan(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhNhanJDBC thongkeJDBC = (ThongKeBenhNhanJDBC) context.getBean("thongKeBenhNhanJDBC");
		List<BenhNhan> benhNhanList = thongkeJDBC.getList();
		model.addAttribute("benhNhanList", benhNhanList);
		model.addAttribute("tongSo", benhNhanList.size());
		return "thongkebenhnhan";
	}

	@RequestMapping(value = "/benh-nhan", method = RequestMethod.POST)
	public String getListTKBenhNhanByDate(HttpServletRequest request, ModelMap model) throws ParseException {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ThongKeBenhNhanJDBC thongkeJDBC = (ThongKeBenhNhanJDBC) context.getBean("thongKeBenhNhanJDBC");
		List<BenhNhan> benhNhanList;
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");

		System.out.println("DateFrom" + dateFrom);
		if ("".equals(dateFrom) && "".equals(dateTo)) {
			benhNhanList = thongkeJDBC.getList();
		} else {
			if(!"".equals(dateFrom)){
				Date dateResult1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
				dateFrom = new SimpleDateFormat("yyyy-MM-dd").format(dateResult1);
			} 
			if(!"".equals(dateTo)){
				Date dateResult2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);
				dateTo = new SimpleDateFormat("yyyy-MM-dd").format(dateResult2);
			}			
			benhNhanList = thongkeJDBC.getByDate(dateFrom, dateTo);			
			if (!"".equals(dateFrom) && "".equals(dateTo)) {
				model.addAttribute("dateFrom",dateFrom);
			} else if ("".equals(dateFrom) && !"".equals(dateTo)) {
				model.addAttribute("dateTo",dateTo);
			} else {
				model.addAttribute("dateFrom",dateFrom);
				model.addAttribute("dateTo",dateTo);
			}
		}
		model.addAttribute("benhNhanList", benhNhanList);
		model.addAttribute("tongSo", benhNhanList.size());
		return "thongkebenhnhan";
	}
	
	@RequestMapping(value = "/benh-nhan/{maBN}", method = RequestMethod.GET)
	public String getChiTietByMaBN(@PathVariable String maBN, ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAttrs, @RequestParam("dateFrom") String dateFrom,@RequestParam("dateTo") String dateTo) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		BenhAnJDBC benhAnJDBC = (BenhAnJDBC) context.getBean("benhAnJDBC");
		BenhAn benhAn = benhAnJDBC.getByMaBN(maBN);
		BenhNhanJDBC benhNhanJDBC = (BenhNhanJDBC) context.getBean("benhNhanJDBC");
		BenhNhan benhNhan = benhNhanJDBC.getOne(benhAn.getMaBenhNhan());
		NhanVienJDBC nhanVienJDBC = (NhanVienJDBC) context.getBean("nhanVienJDBC");
		NhanVien nhanVien = nhanVienJDBC.getNVByMaNV(benhAn.getMaNhanVienKham());

		model.addAttribute("benhAn", benhAn);
		model.addAttribute("benhNhan", benhNhan);
		model.addAttribute("nhanVien", nhanVien);
		return "chitietbenhan";
	}
	
}
