package com.controller.ThongKe;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.ThongKeBenhAn;

@Controller
public class ThongKeController {
	private ApplicationContext context;

	@RequestMapping(value = "/thongkebenhan", method = RequestMethod.GET)
	public String staffmanagement(ModelMap model, HttpServletRequest request) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ArrayList<ThongKeBenhAn> benhAnList = new ArrayList<>();
		benhAnList.add(new ThongKeBenhAn("BA0001", "Phan Văn Quang", new Date("2017/12/06"), "Trần Bá Trọng", "14h20"));
		benhAnList.add(new ThongKeBenhAn("BA0002", "Phan Tấn Minh", new Date("2017/12/06"), "Trần Bá Trọng", "13h20"));
		benhAnList.add(new ThongKeBenhAn("BA0003", "Nguyễn THành Nhân", new Date("2017/12/06"), "Trần Bá Trọng", "12h20"));
		benhAnList.add(new ThongKeBenhAn("BA0004", "Lê Bá Hoàng", new Date("2017/12/06"), "Trần Bá Trọng", "14h20"));
		benhAnList.add(new ThongKeBenhAn("BA0005", "Trần Đặng Hoàng Nguyên", new Date("2017/12/06"), "Trần Bá Trọng", "11h20"));
		benhAnList.add(new ThongKeBenhAn("BA0006", "Lê Bá Khánh Thành", new Date("2017/12/06"), "Trần Bá Trọng", "10h20"));
		benhAnList.add(new ThongKeBenhAn("BA0007", "Trần Văn Giáp", new Date("2017/12/06"), "Trần Bá Trọng", "9h20"));
		benhAnList.add(new ThongKeBenhAn("BA0008", "Phạm Thị Duyên", new Date("2017/12/06"), "Trần Bá Trọng", "8h20"));
		
		model.addAttribute("benhAnList",benhAnList);
		return "thongkebenhan";
	}
}
