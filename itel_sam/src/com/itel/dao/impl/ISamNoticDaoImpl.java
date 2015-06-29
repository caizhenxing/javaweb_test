package com.itel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itel.dao.ISamNoticDao;
import com.itel.dao.utils.BaseDao;
import com.itel.domain.SamNotic;
/**
 * 通知消息持久层实现类
 * @author yangxuan
 *
 */
@Repository
public class ISamNoticDaoImpl implements ISamNoticDao{
	@Autowired
	private BaseDao baseDao;
	/**
	 * 保存通知消息
	 */
	@Override
	public void insertSamNotic(SamNotic samNotic) {
		baseDao.save(samNotic);
	}
	/**
	 * 删除通知消息
	 */
	@Override
	public void deleteSamNotic(String ids) {
		SamNotic samNotic = (SamNotic) this.baseDao.findById(SamNotic.class, ids);
		if(samNotic!=null){
			this.baseDao.delete(samNotic);
		}
	}

}
