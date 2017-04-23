package com.model.DAO.ChucVu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.ChucVu;

public class ChucVuJDBC implements ChucVuDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ChucVu> getAll(){
		String sql="select * from CHUCVU";
		try{
			List<ChucVu> listChucVu = jdbcTemplateObject.query(sql, new ChucVuMapper());
			return listChucVu;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@Override
	public ChucVu getLast(){
		String sql = "select TOP 1 * from CHUCVU ORDER BY MaChucVu DESC";
		try {
			ChucVu chucVu = jdbcTemplateObject.queryForObject(sql, new ChucVuMapper());
			return chucVu;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@Override
	public int add(ChucVu chucVu){
		String sql = "insert into CHUCVU ( MaChucVu, TenChucVu)"
				+ "values(?,?)";
		try {
			return jdbcTemplateObject.update(sql,
					new Object[] { chucVu.getMaChucVu(), chucVu.getTenChucVu() });
		} catch (Exception e) {
			return 0;
		}
	}
	
}