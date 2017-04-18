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
	public List<NhanVien> getAllActive(){
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
	public List<NhanVien> getAllDeActive(){
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
	public int deactivateById(String maNhanVien){
		String sql = "update NHANVIEN set TinhTrang = '0' where MaNhanVien = '" + maNhanVien + "'";
		return jdbcTemplateObject.update(sql);	
	}
	
	@Override
	public int activeById(String maNhanVien){
		String sql = "update NHANVIEN set TinhTrang = '1' where MaNhanVien = '" + maNhanVien + "'";
		return jdbcTemplateObject.update(sql);	
	}
	
}
