package com.itel.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itel.dao.ISamPushDao;
import com.itel.dao.utils.BaseDao;
import com.itel.domain.SamPush;
/**
 * 推送消息持久层实现类
 * @author yangxuan
 *
 */
@Repository
public class ISamPushDaoImpl implements ISamPushDao {
	private final Logger logger = Logger.getLogger(ISamPushDaoImpl.class);
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 保存推送用户信息
	 */
	@Override
	public void saveSamPush(SamPush samPush) {
		this.baseDao.save(samPush);
	}

}