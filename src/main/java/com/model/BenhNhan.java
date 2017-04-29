package com.model;

import java.util.Date;

public class BenhNhan {
	private String maBenhNhan;
	private String tenBenhNhan;
	private Date ngayTao;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String diaChi;
	private String soDienThoai;
	public String getMaBenhNhan() {
		return maBenhNhan;
	}
	public void setMaBenhNhan(String maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}
	public String getTenBenhNhan() {
		return tenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public BenhNhan(String maBenhNhan, String tenBenhNhan, Date ngayTao, Date ngaySinh, boolean gioiTinh, String diaChi,
			String soDienThoai) {
		super();
		this.maBenhNhan = maBenhNhan;
		this.tenBenhNhan = tenBenhNhan;
		this.ngayTao = ngayTao;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public BenhNhan() {
		super();
	}
	
}
