package com.itel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.jpush.api.push.PushResult;

import com.itel.data.GridResult;
import com.itel.domain.PushMessage;
import com.itel.domain.SamPush;
import com.itel.domain.SamPushMsg;
import com.itel.service.ISamPushMsgService;
import com.itel.service.ISamPushService;
import com.itel.tools.ControllerSupport;

/**
 * 消息通知推送类
 * @author yangxuan
 *
 */
@Controller
@RequestMapping("/samPushController")
public class SamPushController extends ControllerSupport<SamPush>{
	@Autowired
	private ISamPushService iSamPushService;
	@Autowired
	private ISamPushMsgService iSamPushMsgService;
	
	
	/**
	 * 手机设备第一次注册
	 */
	@Override
	public ModelAndView add(SamPush entity) {
		GridResult gridResult = iSamPushService.saveSamPush(entity);
		return new ModelAndView("jsonView",gridResult);
	}
	
	/**
	 * 推送消息
	 * @param pushMessage
	 * @return
	 */
	@RequestMapping(value="/pushMessage",method=RequestMethod.POST)
	public ModelAndView pushMessage(PushMessage pushMessage){
		iSamPushService.saveSamPushMsg(pushMessage);
		
		return new ModelAndView("jsonView");
	}
	
	@RequestMapping(value="/getPushMsgList",method=RequestMethod.GET)
	public ModelAndView getPushMsgList(){
		GridResult<SamPushMsg> gridResult = iSamPushMsgService.getSamPushMsgList();
		return new ModelAndView("jsonView",gridResult);
	}
	
	
	
	

}
