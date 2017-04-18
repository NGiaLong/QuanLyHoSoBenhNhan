package com.model;

public class ChucVu {
	private String MaChucVu;
	private String TenChucVu;
	public String getMaChucVu() {
		return MaChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		MaChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return TenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		TenChucVu = tenChucVu;
	}
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		MaChucVu = maChucVu;
		TenChucVu = tenChucVu;
	}
	public ChucVu() {
		super();
	}
	
}
