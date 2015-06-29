package com.itel.service;

import com.itel.data.GridResult;
import com.itel.domain.PushMessage;
import com.itel.domain.SamPush;

/**
 * 设备推送服务接口
 * @author yangxuan
 *
 */
public interface ISamPushService {
	
	/**
	 * 保存推送信息(注册信息)
	 * @param samPush
	 * @return
	 */
	GridResult saveSamPush(SamPush samPush);
	
	/**
	 * 消息通知推送服务
	 * @param pushMessage
	 * @return
	 */
	GridResult saveSamPushMsg(PushMessage pushMessage);

}