package com.controller.NhanVien;

import javax.validation.constraints.Past;

public class ThemChucVuBean {
	@Past
	private String tenChucVu;

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public ThemChucVuBean(String tenChucVu) {
		super();
		this.tenChucVu = tenChucVu;
	}

	public ThemChucVuBean() {
		super();
	}
	
}
