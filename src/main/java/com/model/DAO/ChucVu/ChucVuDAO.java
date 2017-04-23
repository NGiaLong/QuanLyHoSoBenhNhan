package com.model.DAO.ChucVu;

import java.util.List;
import com.model.ChucVu;

public interface ChucVuDAO {
	public List<ChucVu> getAll();
	public ChucVu getLast();
	public int add(ChucVu chucVu);
}
