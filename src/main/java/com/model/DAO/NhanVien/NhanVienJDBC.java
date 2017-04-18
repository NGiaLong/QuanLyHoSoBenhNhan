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
		String sql = "SELECT * from NHANVIEN where TinhTrang = 1";
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
		String sql = "SELECT * from NHANVIEN where TinhTrang = 0";
		try {
			List<NhanVien> listNhanVien = jdbcTemplateObject.query(sql, new NhanVienMapper());			
			return listNhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
