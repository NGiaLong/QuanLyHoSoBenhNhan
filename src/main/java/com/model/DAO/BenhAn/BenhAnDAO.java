package com.model.DAO.BenhAn;

import com.model.BenhAn;

public interface BenhAnDAO {
	public BenhAn getOne(String id);
	public BenhAn getByMaBN(String maBN);
}
