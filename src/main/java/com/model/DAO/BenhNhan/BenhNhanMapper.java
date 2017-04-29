package com.model.DAO.BenhNhan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.BenhNhan;


public class BenhNhanMapper implements RowMapper<BenhNhan>{
	public BenhNhan mapRow(ResultSet rs, int rowNum) throws SQLException{
		BenhNhan benhNhan = new BenhNhan();
		benhNhan.setMaBenhNhan(rs.getString(1));
		benhNhan.setTenBenhNhan(rs.getString(2));
		benhNhan.setNgayTao(rs.getDate(3));
		benhNhan.setNgaySinh(rs.getDate(4));
		benhNhan.setGioiTinh(rs.getBoolean(5));
		benhNhan.setDiaChi(rs.getString(6));
		benhNhan.setSoDienThoai(rs.getString(7));
		return benhNhan;
	}
}
