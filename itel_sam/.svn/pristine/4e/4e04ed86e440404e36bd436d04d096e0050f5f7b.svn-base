package com.itel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itel.dao.ISamHelpCenterDao;
import com.itel.dao.utils.BaseDao;
import com.itel.domain.SamHelpCenter;
/**
 * 帮助中心持久层实现类
 * @author yangxuan
 *
 */
@Repository
public class ISamHelpCenterDaoImpl implements ISamHelpCenterDao {
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 删除帮助中心信息
	 * @param 主键
	 */
	@Override
	public void deleteSamHelpCenter(String id) {
		SamHelpCenter samHelpCenter = (SamHelpCenter) this.baseDao.findById(SamHelpCenter.class, Integer.parseInt(id));
		if(samHelpCenter!=null){
			this.baseDao.delete(samHelpCenter);
		}
	}

}
