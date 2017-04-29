package com.model.DAO.BenhNhan;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.BenhAn;
import com.model.BenhNhan;
import com.model.DAO.BenhAn.BenhAnMapper;

public class BenhNhanJDBC implements BenhNhanDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public BenhNhan getOne(String maBenhNhan) {
		String sql = "SELECT * FROM BENHNHAN WHERE BENHNHAN.MaBenhNhan = ?";
		try {
			BenhNhan benhNhan = jdbcTemplateObject.queryForObject(sql, new Object[] { maBenhNhan }, new BenhNhanMapper());
			return benhNhan;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
