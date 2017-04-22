package com.model.DAO.ThongKeBenhAn;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.ThongKeBenhAn;

public class ThongKeBenhAnMapper implements RowMapper<ThongKeBenhAn> {
	public ThongKeBenhAn mapRow(ResultSet rs, int rowNum) throws SQLException{
		ThongKeBenhAn tkBenhAn = new ThongKeBenhAn();
		tkBenhAn.setMaBenhAn(rs.getString(1));
		tkBenhAn.setMaNhanVien(rs.getString(2));
		tkBenhAn.setTenNhanVien(rs.getString(3));
		tkBenhAn.setMaBenhNhan(rs.getString(4));
		tkBenhAn.setTenBenhNhan(rs.getString(5));
		tkBenhAn.setNgayKham(rs.getDate(6));
		tkBenhAn.setGioKham(rs.getString(7));
		return tkBenhAn;
	}
}
