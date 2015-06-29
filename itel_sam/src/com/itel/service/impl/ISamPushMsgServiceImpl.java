package com.itel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itel.dao.ISamPushMsgDao;
import com.itel.data.GridResult;
import com.itel.domain.SamPushMsg;
import com.itel.service.ISamPushMsgService;

/**
 * 推送消息记录服务接口实现类
 * @author yangxuan
 *
 */
@Service
public class ISamPushMsgServiceImpl implements ISamPushMsgService {

	@Autowired
	private ISamPushMsgDao iSamPushMsgDao;

	/**
	 * 保存推送消息记录
	 */
	@Override
	public GridResult saveSamPushMsg(SamPushMsg samPushMsg) {
		GridResult gridResult = new GridResult();
		try{
			iSamPushMsgDao.saveSamPushMsg(samPushMsg);
		}catch(Exception e){
			gridResult.setMsg("对不起,系统异常");
			gridResult.setSuccess(false);
		}
		return gridResult;
	}
	
	/**
	 * 获取推送消息记录列表
	 */
	@Override
	public GridResult<SamPushMsg> getSamPushMsgList() {
		List<SamPushMsg> list = iSamPushMsgDao.getSamPushMsgList();
		return new GridResult<SamPushMsg>(list,list.size());
	}

}
