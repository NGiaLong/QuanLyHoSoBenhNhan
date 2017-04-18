package com.model.DAO.ChucVu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.ChucVu;
import com.model.DAO.ChucVu.*;

public class ChucVuJDBC implements ChucVuDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public List<ChucVu> getAll(){
		String sql="";
		try{
			List<ChucVu> listChucVu = jdbcTemplateObject.query(sql, new ChucVuMapper());
			return listChucVu;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}