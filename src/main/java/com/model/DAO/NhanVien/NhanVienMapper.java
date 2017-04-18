package com.model.DAO.NhanVien;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.NhanVien;

public class NhanVienMapper implements RowMapper<NhanVien> {
	public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException{
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNhanVien(rs.getString(1));
		nhanVien.setTenNhanVien(rs.getString(2));
		nhanVien.setMatKhau(rs.getString(3));
		nhanVien.setGioiTinh(rs.getBoolean(4));
		nhanVien.setNgaySinh(rs.getString(5));
		nhanVien.setDiaChi(rs.getString(6));
		nhanVien.setSoDienThoai(rs.getString(7));
		nhanVien.setMaChucVu(rs.getString(8));
		nhanVien.setChucVu(rs.getString("TenChucVu"));
		nhanVien.setTinhTrang(rs.getBoolean(9));
		return nhanVien;
	}
}
