package com.itel.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.itel.dao.ISamPushDao;
import com.itel.data.GridResult;
import com.itel.domain.PushMessage;
import com.itel.domain.SamPush;
import com.itel.domain.SamPushMsg;
import com.itel.service.ISamPushMsgService;
import com.itel.service.ISamPushService;
import com.itel.tools.JPushUtils;
import com.itel.utils.Constants;

/**
 * 推送消息服务接口实现类
 * @author yangxuan
 *
 */
@Service
public class ISamPushServiceImpl implements ISamPushService {
	@Autowired
	private ISamPushDao iSamPushDao;
	@Autowired
	private JPushUtils jPushUtils;
	@Autowired
	private ISamPushMsgService iSamPushMsgService;
	
	
	@Override
	public GridResult saveSamPush(SamPush samPush) {
		GridResult gridResult = new GridResult();
		samPush.setUid(UUID.randomUUID().toString());
		try {
			this.iSamPushDao.saveSamPush(samPush);
			gridResult.setSuccess(true);
		} catch (Exception e) {
			gridResult.setSuccess(false);
			gridResult.setMsg("对不起,系统异常");
		}
		return gridResult;
	}
	/*@Override
	public GridResult saveSamPushMsg(PushMessage pushMessage) {
		GridResult gridResult = new GridResult();
		PushPayload.Builder p = PushPayload.newBuilder();
		SamPushMsg samPushMsg = new SamPushMsg();
		String msg = "";
		try {
			msg = parasMessage(pushMessage.getTitle(), pushMessage.getContent(),pushMessage.getMsgType());
		} catch (JSONException e) {
			gridResult.setSuccess(false);
			gridResult.setMsg("解析内容异常");
		}
		
		//设备平台处理 start
		String platForm = pushMessage.getPlatForm();
		Options.Builder optionsBuilder = Options.newBuilder();
		if(Constants.PUSH_AllPlatForm.equals(platForm)){
			p.setPlatform(Platform.all());
		}else if(Constants.PUSH_AndroidPlatForm.equals(platForm)){
			p.setPlatform(Platform.android());
		}else if(Constants.PUSH_IOSPlatForm.equals(platForm)){
			p.setPlatform(Platform.ios());
		} 
		
		//IOS环境
		String iosenv = pushMessage.getIosenv();
		if(Constants.PUSH_IOS_dev.equals(iosenv)){
			optionsBuilder.setApnsProduction(false);
		}else if(Constants.PUSH_IOS_pro.equals(iosenv)){
			optionsBuilder.setApnsProduction(true);
		}
		Options options = optionsBuilder.build();
		p.setOptions(options);
		//设备平台处理 end
		
		
		//发送对象处理 start
		String target = pushMessage.getTarget();
		if(Constants.PUSH_Target_All.equals(target)){
			p.setAudience(Audience.all());
			samPushMsg.setAlltarget("Y");
		}else if(Constants.PUSH_Target_Alias.equals(target)){
			p.setAudience(Audience.alias(pushMessage.getUitel()));
			samPushMsg.setAlias(pushMessage.getUitel());
		}else if(Constants.PUSH_Target_Registration.equals(target)){
			p.setAudience(Audience.registrationId(pushMessage.getChannel()));
			samPushMsg.setRegistrationid(pushMessage.getChannel());
		}
		//发送对象处理 end
		
		//消息类型处理 start
		String type = pushMessage.getType();
		if (Constants.PUSH_Notification.equals(type)) {
			msg = pushMessage.getContent();
			Notification.Builder noBuilder = Notification.newBuilder();
			IosNotification iosNotification = IosNotification.alert(msg);
			AndroidNotification androidNotification = AndroidNotification.alert(msg);
			noBuilder.addPlatformNotification(iosNotification);
			noBuilder.addPlatformNotification(androidNotification);
			Notification notification = noBuilder.build();
			p.setNotification(notification);
		} else if (Constants.PUSH_Message.equals(type)) {
			Message message = Message.content(msg);
			p.setMessage(message);
		}
		//消息类型处理 end
		
		PushPayload pushPayload = p.build();
		PushResult pushResult = jPushUtils.sendMsg(pushPayload);
		System.out.println(pushResult.msg_id);
		System.out.println(pushResult.getErrorMessage());
		if(pushResult.isResultOK()){
			samPushMsg.setUid(UUID.randomUUID().toString());
			samPushMsg.setTitle(pushMessage.getTitle());
			samPushMsg.setContent(pushMessage.getContent());
			samPushMsg.setMsgtype(pushMessage.getMsgType());
			samPushMsg.setPushtype(pushMessage.getType());
			samPushMsg.setPlatform(pushMessage.getPlatForm());
			iSamPushMsgService.saveSamPushMsg(samPushMsg);
		}
		return gridResult;

	}*/
	
	
	@Override
	public GridResult saveSamPushMsg(PushMessage pushMessage) {
		GridResult gridResult = new GridResult();
		PushPayload.Builder p = PushPayload.newBuilder();
		SamPushMsg samPushMsg = new SamPushMsg();
		String msg = "";
		try {
			msg = parasMessage(pushMessage.getTitle(), pushMessage.getContent(),pushMessage.getMsgType());
		} catch (JSONException e) {
			gridResult.setSuccess(false);
			gridResult.setMsg("解析内容异常");
		}
		
		//设备平台处理 start
		String platForm = pushMessage.getPlatForm();
		Options.Builder optionsBuilder = Options.newBuilder();
		if(Constants.PUSH_AllPlatForm.equals(platForm)){
			p.setPlatform(Platform.all());
		}else if(Constants.PUSH_AndroidPlatForm.equals(platForm)){
			p.setPlatform(Platform.android());
		}else if(Constants.PUSH_IOSPlatForm.equals(platForm)){
			p.setPlatform(Platform.ios());
		} 
		
		//IOS环境
		String iosenv = pushMessage.getIosenv();
		if(Constants.PUSH_IOS_dev.equals(iosenv)){
			optionsBuilder.setApnsProduction(false);
		}else if(Constants.PUSH_IOS_pro.equals(iosenv)){
			optionsBuilder.setApnsProduction(true);
		}
		Options options = optionsBuilder.build();
		p.setOptions(options);
		//设备平台处理 end
		
		
		//发送对象处理 start
		String target = pushMessage.getTarget();
		if(Constants.PUSH_Target_All.equals(target)){
			p.setAudience(Audience.all());
			samPushMsg.setAlltarget("Y");
		}else if(Constants.PUSH_Target_Alias.equals(target)){
			p.setAudience(Audience.alias(pushMessage.getUitel()));
			samPushMsg.setAlias(pushMessage.getUitel());
		}else if(Constants.PUSH_Target_Registration.equals(target)){
			p.setAudience(Audience.registrationId(pushMessage.getChannel()));
			samPushMsg.setRegistrationid(pushMessage.getChannel());
		}
		//发送对象处理 end
		
		//消息类型处理 start
		String type = pushMessage.getType();
		if (Constants.PUSH_Notification.equals(type)) {
			msg = pushMessage.getContent();
			Notification.Builder noBuilder = Notification.newBuilder();
			
			IosNotification.Builder iosNotificationBuilder = IosNotification.newBuilder();
			iosNotificationBuilder.setAlert(msg);
			iosNotificationBuilder.setBadge(1);
			iosNotificationBuilder.setSound("notificationSound2.wma");
			IosNotification iosNotification = iosNotificationBuilder.build();
			
			AndroidNotification.Builder androidNotificationBuilder = AndroidNotification.newBuilder();
			androidNotificationBuilder.setAlert(msg);
			androidNotificationBuilder.setTitle(pushMessage.getTitle());
			AndroidNotification androidNotification = androidNotificationBuilder.build();
			
			noBuilder.addPlatformNotification(iosNotification);
			noBuilder.addPlatformNotification(androidNotification);
			Notification notification = noBuilder.build();
			p.setNotification(notification);
		} else if (Constants.PUSH_Message.equals(type)) {
			Message.Builder messageBuilder = Message.newBuilder();
			messageBuilder.setMsgContent(msg);
			Message message = messageBuilder.build();
			p.setMessage(message);
		}
		//消息类型处理 end
		
		PushPayload pushPayload = p.build();
		PushResult pushResult = jPushUtils.sendMsg(pushPayload);
		System.out.println(pushResult.msg_id);
		System.out.println(pushResult.getErrorMessage());
		if(pushResult.isResultOK()){
			samPushMsg.setUid(UUID.randomUUID().toString());
			samPushMsg.setTitle(pushMessage.getTitle());
			samPushMsg.setContent(pushMessage.getContent());
			samPushMsg.setMsgtype(pushMessage.getMsgType());
			samPushMsg.setPushtype(pushMessage.getType());
			samPushMsg.setPlatform(pushMessage.getPlatForm());
			iSamPushMsgService.saveSamPushMsg(samPushMsg);
		}
		return gridResult;

	}
	
	/**
	 * 发送给所有设备
	 * @param msg
	 */
	public void sendAll(String msg) {
		jPushUtils.sendMessageByAll(msg);
	}
	/**
	 * 标题,内容组装json方法
	 * @param title
	 * @param content
	 * @return
	 * @throws JSONException
	 */
	public String parasMessage(String title, String content,String msgtype)
			throws JSONException {
		JSONObject json = new JSONObject();
		if (title != null) {
			json.put("title", title);
		}
		if (content != null) {
			json.put("content", content);
		}
		if (msgtype != null) {
			json.put("msgtype", msgtype);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		json.put("date", date);
		return json.toString();
	}

}
