package com.model;

import java.util.Date;

public class ThongKeBenhAn {
	private String maBenhAn;
	private String tenNhanVien;
	private Date ngayKham;
	private String tenBenhNhan;
	private String gioKham;
	
	public String getMaBenhAn() {
		return maBenhAn;
	}
	public void setMaBenhAn(String maBenhAn) {
		this.maBenhAn = maBenhAn;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Date getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}
	public String getTenBenhNhan() {
		return tenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}
	public String getGioKham() {
		return gioKham;
	}
	public void setGioKham(String gioKham) {
		this.gioKham = gioKham;
	}
	public ThongKeBenhAn(String maBenhAn, String tenBenhNhan, Date date, String tenNhanVien, String gioKham) {
		super();
		this.maBenhAn = maBenhAn;
		this.tenNhanVien = tenNhanVien;
		this.ngayKham = date;
		this.tenBenhNhan = tenBenhNhan;
		this.gioKham = gioKham;
	}
	
}	
