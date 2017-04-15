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
	public List<NhanVien> getAll(){
		String sql = "SELECT * from NHANVIEN";
		try {
			List<NhanVien> listNhanVien = jdbcTemplateObject.query(sql, new NhanVienMapper());			
			return listNhanVien;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
