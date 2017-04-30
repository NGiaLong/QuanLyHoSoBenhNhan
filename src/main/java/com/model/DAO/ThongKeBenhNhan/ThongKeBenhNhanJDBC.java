package com.model.DAO.ThongKeBenhNhan;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.BenhNhan;
import com.model.DAO.ThongKeBenhNhan.ThongKeBenhNhanMapper;

public class ThongKeBenhNhanJDBC implements ThongKeBenhNhanDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<BenhNhan> getList() {
		String sql = "SELECT bn.MaBenhNhan, bn.TenBenhNhan,bn.NgaySinh, COUNT(ba.MaBenhAnChiTiet) as 'SoLanKham' "
				+ "FROM BENHNHAN bn, BENHANCHITIET ba WHERE  bn.MaBenhNhan = ba.MaBenhNhan GROUP BY bn.MaBenhNhan, bn.TenBenhNhan, bn.NgaySinh ";
		try {
			List<BenhNhan> listTKBenhNhan = jdbcTemplateObject.query(sql, new ThongKeBenhNhanMapper());
			return listTKBenhNhan;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<BenhNhan> getByDate(String dateFrom, String dateTo) {
		String sql = "";
		if(!"".equals(dateFrom)&&!"".equals(dateTo)){
			sql = "SELECT bn.MaBenhNhan, bn.TenBenhNhan,bn.NgaySinh, COUNT(ba.MaBenhAnChiTiet) as 'SoLanKham' "
					+ "FROM BENHNHAN bn, BENHANCHITIET ba WHERE  bn.MaBenhNhan = ba.MaBenhNhan "
					+ "AND (ba.NgayKham BETWEEN '"+dateFrom+"' AND '"+dateTo+"') GROUP BY bn.MaBenhNhan, bn.TenBenhNhan, bn.NgaySinh ";
		} else if(!"".equals(dateFrom)&&"".equals(dateTo)){
			sql = "SELECT bn.MaBenhNhan, bn.TenBenhNhan,bn.NgaySinh, COUNT(ba.MaBenhAnChiTiet) as 'SoLanKham' FROM BENHNHAN bn, BENHANCHITIET ba "
					+ "WHERE  bn.MaBenhNhan = ba.MaBenhNhan AND (ba.NgayKham >= '"+dateFrom+"') GROUP BY bn.MaBenhNhan, bn.TenBenhNhan, bn.NgaySinh ";
		} else {
			sql = "SELECT bn.MaBenhNhan, bn.TenBenhNhan,bn.NgaySinh, COUNT(ba.MaBenhAnChiTiet) as 'SoLanKham' FROM BENHNHAN bn, BENHANCHITIET ba "
					+ "WHERE  bn.MaBenhNhan = ba.MaBenhNhan AND (ba.NgayKham <= '"+dateTo+"') GROUP BY bn.MaBenhNhan, bn.TenBenhNhan, bn.NgaySinh ";
		}		
		try {
			List<BenhNhan> listTKBenhNhan = jdbcTemplateObject.query(sql, new ThongKeBenhNhanMapper());
			return listTKBenhNhan;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
