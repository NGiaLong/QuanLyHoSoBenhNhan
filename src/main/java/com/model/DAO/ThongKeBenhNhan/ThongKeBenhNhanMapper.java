package com.model.DAO.ThongKeBenhNhan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.BenhNhan;

public class ThongKeBenhNhanMapper implements RowMapper<BenhNhan> {
	public BenhNhan mapRow(ResultSet rs, int rowNum) throws SQLException{
		BenhNhan benhNhan = new BenhNhan();
		benhNhan.setMaBenhNhan(rs.getString(1));
		benhNhan.setTenBenhNhan(rs.getString(2));
		benhNhan.setNgaySinh(rs.getDate(3));
		benhNhan.setSoLanKham(rs.getString(4));		
		return benhNhan;
	}
}
