package com.itel.dao;

import java.util.List;

import com.itel.domain.SamPushMsg;

/**
 * 推送消息持久层Dao
 * @author yangxuan
 *
 */
public interface ISamPushMsgDao {
	
	/**
	 * 新增推送消息
	 * @param samPushMsg
	 */
	public void saveSamPushMsg(SamPushMsg samPushMsg);
	
	/**
	 * 获取推送消息集合
	 * @return
	 */
	public List<SamPushMsg> getSamPushMsgList();

}
