package com.model.DAO.ThongKeBenhNhan;

import java.util.List;

import com.model.BenhNhan;

public interface ThongKeBenhNhanDAO {
	public List<BenhNhan> getList();
	public List<BenhNhan> getByDate(String dateFrom, String dateTo);
	
}
