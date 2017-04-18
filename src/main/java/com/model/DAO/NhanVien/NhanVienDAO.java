package com.model.DAO.NhanVien;

import java.util.List;

import com.model.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> getAllActive();
	public List<NhanVien> getAllDeActive();
	public int deactivateById(String maNhanVien);
	public int activeById(String maNhanVien);
}
