package com.model.DAO.BenhAn;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.BenhAn;


public class BenhAnMapper implements RowMapper<BenhAn>{
	public BenhAn mapRow(ResultSet rs, int rowNum) throws SQLException{
		BenhAn benhAn = new BenhAn();
		benhAn.setMaBenhAn(rs.getString(1));
		benhAn.setNgayKham(rs.getDate(2));
		benhAn.setGioKham(rs.getString(3));
		benhAn.setMaBenhNhan(rs.getString(4));
		benhAn.setMaNhanVienKham(rs.getString(5));
		benhAn.setTrieuChung(rs.getString(6));
		benhAn.setChanDoan(rs.getString(7));
		return benhAn;
	}
}
