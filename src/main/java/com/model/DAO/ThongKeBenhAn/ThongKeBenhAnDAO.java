package com.model.DAO.ThongKeBenhAn;

import java.util.Date;
import java.util.List;

import com.model.ThongKeBenhAn;;

public interface ThongKeBenhAnDAO {
	public List<ThongKeBenhAn> getList();
	public List<ThongKeBenhAn> getByDate(String date);
	public List<ThongKeBenhAn> getByMonth(int month, int year);
	public List<ThongKeBenhAn> getByYear(int year);
}
