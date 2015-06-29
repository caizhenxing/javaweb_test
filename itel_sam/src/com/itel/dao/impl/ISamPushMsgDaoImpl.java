package com.itel.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itel.dao.ISamPushMsgDao;
import com.itel.dao.utils.BaseDao;
import com.itel.domain.SamPushMsg;
/**
 * 推送消息持久层实现类
 * @author yangxuan
 *
 */
@Repository
public class ISamPushMsgDaoImpl implements ISamPushMsgDao {
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 保存推送消息记录
	 */
	@Override
	public void saveSamPushMsg(SamPushMsg samPushMsg) {
		this.baseDao.save(samPushMsg);
	}
	
	/**
	 * 获取推送消息列表
	 */
	@Override
	public List<SamPushMsg> getSamPushMsgList() {
		return this.baseDao.findAll(" SamPushMsg");
	}

}
