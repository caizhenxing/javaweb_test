package com.itel.dao;

import com.itel.domain.SamNotic;

public interface ISamNoticDao {
	
	void insertSamNotic(SamNotic samNotic);
	
	void deleteSamNotic(String id);

}
