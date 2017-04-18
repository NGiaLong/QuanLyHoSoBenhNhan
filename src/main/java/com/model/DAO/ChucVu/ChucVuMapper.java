package com.model.DAO.ChucVu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.ChucVu;

public class ChucVuMapper implements RowMapper<ChucVu> {
	public ChucVu mapRow(ResultSet rs, int rowNum) throws SQLException{
		ChucVu chucVu = new ChucVu();
		chucVu.setMaChucVu(rs.getString(1));
		chucVu.setTenChucVu(rs.getString(2));
		return chucVu;
	}
}
