package com.model.DAO.ThongKeBenhAn;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.ThongKeBenhAn;
import com.model.DAO.ThongKeBenhAn.ThongKeBenhAnMapper;

public class ThongKeBenhAnJDBC implements ThongKeBenhAnDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ThongKeBenhAn> getList() {
		String sql = "SELECT ba.MaBenhAnChiTiet, nv.MaNhanVien, nv.TenNhanVien, bn.MaBenhNhan,bn.TenBenhNhan, ba.NgayKham, ba. GioKham"
				+ " FROM dbo.BENHANCHITIET ba, dbo.BENHNHAN bn, dbo.NHANVIEN nv WHERE ba.MaBenhNhan = bn.MaBenhNhan AND ba.MaNhanVienKham = nv.MaNhanVien";
		try {
			List<ThongKeBenhAn> listTKBenhAn = jdbcTemplateObject.query(sql, new ThongKeBenhAnMapper());
			return listTKBenhAn;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<ThongKeBenhAn> getByDate(String date) {
		String sql = "SELECT ba.MaBenhAnChiTiet, nv.MaNhanVien, nv.TenNhanVien, bn.MaBenhNhan,bn.TenBenhNhan, ba.NgayKham, ba. GioKham"
				+ " FROM dbo.BENHANCHITIET ba, dbo.BENHNHAN bn, dbo.NHANVIEN nv WHERE ba.MaBenhNhan = bn.MaBenhNhan AND ba.MaNhanVienKham = nv.MaNhanVien AND ba.NgayKham = '"+date+"'";
		try {
			List<ThongKeBenhAn> listTKBenhAn = jdbcTemplateObject.query(sql, new ThongKeBenhAnMapper());
			return listTKBenhAn;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<ThongKeBenhAn> getByMonth(int month, int year) {
		String sql = "SELECT ba.MaBenhAnChiTiet, nv.MaNhanVien, nv.TenNhanVien, bn.MaBenhNhan,bn.TenBenhNhan, ba.NgayKham, ba. GioKham"
				+ " FROM dbo.BENHANCHITIET ba, dbo.BENHNHAN bn, dbo.NHANVIEN nv WHERE ba.MaBenhNhan = bn.MaBenhNhan AND ba.MaNhanVienKham = nv.MaNhanVien AND MONTH(ba.NgayKham) = "+month+" AND YEAR(ba.NgayKham) = "+ year;
		try {
			List<ThongKeBenhAn> listTKBenhAn = jdbcTemplateObject.query(sql, new ThongKeBenhAnMapper());
			return listTKBenhAn;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<ThongKeBenhAn> getByYear(int year) {
		String sql = "SELECT ba.MaBenhAnChiTiet, nv.MaNhanVien, nv.TenNhanVien, bn.MaBenhNhan,bn.TenBenhNhan, ba.NgayKham, ba. GioKham"
				+ " FROM dbo.BENHANCHITIET ba, dbo.BENHNHAN bn, dbo.NHANVIEN nv WHERE ba.MaBenhNhan = bn.MaBenhNhan AND ba.MaNhanVienKham = nv.MaNhanVien AND YEAR(ba.NgayKham) = "+ year;
		try {
			List<ThongKeBenhAn> listTKBenhAn = jdbcTemplateObject.query(sql, new ThongKeBenhAnMapper());
			return listTKBenhAn;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
