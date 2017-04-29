package com.model;

import java.util.Date;

public class BenhAn {
	private String maBenhAn;
	private Date ngayKham;
	private String gioKham;
	private String maBenhNhan;
	private String maNhanVienKham;
	private String trieuChung;
	private String chanDoan;
	public String getMaBenhAn() {
		return maBenhAn;
	}
	public void setMaBenhAn(String maBenhAn) {
		this.maBenhAn = maBenhAn;
	}
	public Date getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}
	public String getGioKham() {
		return gioKham;
	}
	public void setGioKham(String gioKham) {
		this.gioKham = gioKham;
	}
	public String getMaBenhNhan() {
		return maBenhNhan;
	}
	public void setMaBenhNhan(String maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}
	public String getMaNhanVienKham() {
		return maNhanVienKham;
	}
	public void setMaNhanVienKham(String maNhanVienKham) {
		this.maNhanVienKham = maNhanVienKham;
	}
	public String getTrieuChung() {
		return trieuChung;
	}
	public void setTrieuChung(String trieuChung) {
		this.trieuChung = trieuChung;
	}
	public String getChanDoan() {
		return chanDoan;
	}
	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}
	public BenhAn(String maBenhAn, Date ngayKham, String gioKham, String maBenhNhan, String maNhanVienKham,
			String trieuChung, String chanDoan) {
		super();
		this.maBenhAn = maBenhAn;
		this.ngayKham = ngayKham;
		this.gioKham = gioKham;
		this.maBenhNhan = maBenhNhan;
		this.maNhanVienKham = maNhanVienKham;
		this.trieuChung = trieuChung;
		this.chanDoan = chanDoan;
	}
	public BenhAn(){}
}
