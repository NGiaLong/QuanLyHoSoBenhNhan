package com.model.DAO.NhanVien;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.NhanVien;
import com.model.DAO.NhanVien.NhanVienMapper;

public class NhanVienJDBC implements NhanVienDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<NhanVien> getAllActive() {
		String sql = "select * from NHANVIEN nv left join CHUCVU cv on nv.MaChucVu = cv.MaChucVu where nv.TinhTrang = 1";
		try {
			List<NhanVien> listNhanVien = jdbcTemplateObject.query(sql, new NhanVienMapper());
			return listNhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<NhanVien> getAllDeActive() {
		String sql = "select * from NHANVIEN nv left join CHUCVU cv on nv.MaChucVu = cv.MaChucVu where nv.TinhTrang = 0";
		try {
			List<NhanVien> listNhanVien = jdbcTemplateObject.query(sql, new NhanVienMapper());
			return listNhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public int deactivateById(String maNhanVien) {
		String sql = "update NHANVIEN set TinhTrang = '0' where MaNhanVien = '" + maNhanVien + "'";
		return jdbcTemplateObject.update(sql);
	}

	@Override
	public int activeById(String maNhanVien) {
		String sql = "update NHANVIEN set TinhTrang = '1' where MaNhanVien = '" + maNhanVien + "'";
		return jdbcTemplateObject.update(sql);
	}

	@Override
	public NhanVien getNVByMaNV(String maNV) {
		String sql = "select * from NHANVIEN nv left join CHUCVU cv on nv.MaChucVu = cv.MaChucVu where nv.MaNhanVien = ?";
		try {
			NhanVien nhanVien = jdbcTemplateObject.queryForObject(sql, new Object[] { maNV }, new NhanVienMapper());
			return nhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@Override
	public NhanVien getLast(){
		String sql = "select TOP 1 * from NHANVIEN nv left join CHUCVU cv on nv.MaChucVu = cv.MaChucVu ORDER BY nv.MaNhanVien DESC";
		try {
			NhanVien nhanVien = jdbcTemplateObject.queryForObject(sql, new NhanVienMapper());
			return nhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public int add(NhanVien nhanvien) {
		String sql = "insert into NhanVien ( MaNhanVien, TenNhanVien, MatKhau, GioiTinh, NgaySinh, DiaChi, SoDienThoai, MaChucVu, TinhTrang)"
				+ "values(?,?,'123456',?,?,?,?,?,'1')";
		try {
			return jdbcTemplateObject.update(sql,
					new Object[] { nhanvien.getMaNhanVien(), nhanvien.getTenNhanVien(), nhanvien.isGioiTinh(),
							nhanvien.getNgaySinh(), nhanvien.getDiaChi(), nhanvien.getSoDienThoai(),
							nhanvien.getMaChucVu() });
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int sua(NhanVien nhanvien) {
		String sql = "update NhanVien set TenNhanVien = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, SoDienThoai = ?, MaChucVu = ? where MaNhanVien = ? ";
		try {
			return jdbcTemplateObject.update(sql,
					new Object[] { nhanvien.getTenNhanVien(), nhanvien.isGioiTinh(),
							nhanvien.getNgaySinh(), nhanvien.getDiaChi(), nhanvien.getSoDienThoai(),
							nhanvien.getMaChucVu(), nhanvien.getMaNhanVien() });
		} catch (Exception e) {
			return 0;
		}
	}

}
