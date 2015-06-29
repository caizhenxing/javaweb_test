package com.itel.dao;

import com.itel.domain.SamPush;


/**
 * 设备推送持久类
 * @author yangxuan
 *
 */
public interface ISamPushDao {
	
	/**
	 * 保存设备推送信息(注册信息)
	 * @param samPush
	 */
	void saveSamPush(SamPush samPush);
	 
}
