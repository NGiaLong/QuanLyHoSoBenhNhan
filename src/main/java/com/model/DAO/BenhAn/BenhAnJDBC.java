package com.model.DAO.BenhAn;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.BenhAn;
import com.model.NhanVien;
import com.model.DAO.NhanVien.NhanVienMapper;


public class BenhAnJDBC implements BenhAnDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public BenhAn getOne(String id) {
		String sql = "SELECT * FROM BENHANCHITIET WHERE BENHANCHITIET.MaBenhAnChiTiet = ?";
		try {
			BenhAn benhAn = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new BenhAnMapper());
			return benhAn;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public BenhAn getByMaBN(String maBN) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
