package com.sun.test;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.itel.dao.ISamUpgradeDao;
import com.itel.domain.SamUpgrade;
import com.itel.tools.JPushUtils;

public class SpringTest {
	
	private static JPushClient client;
	
	public static void sendMsgByPerson(String regId,String msg ){
//		 Builder builder = PushPayload.newBuilder();
		 Audience audience = Audience.registrationId(regId);
//		 builder.setAudience(audience);
		 PushPayload.Builder p = PushPayload.newBuilder();
		 p.setAudience(audience);
		 p.setPlatform(Platform.android());
		 Notification notification = Notification.alert(msg);
		 p.setNotification(notification);
		 PushPayload pp =  p.build();
		 PushResult result = client.sendPush(pp);
		 
		 System.out.println(result.isResultOK());
	}
	
	
	 
	
	
	public static void main(String[] args){
		XmlBeanFactory context=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

		JPushUtils jPushUtils=(JPushUtils)context.getBean("jPushUtils");
//		client = jPushUtils.getClient();
//		sendMsgByPerson("0701dccb73b","sendMsgByPerson");
//		jPushUtils.sendMsg("this is Spring FrameWork IOC...");
//		jPushUtils.sendMessageByAll("");
//		jPushUtils.sendMessageByAll("this is main method");
//		jPushUtils.sendMessageByAllToAndroid("this is sendMessageByAndroid");
		jPushUtils.sendMessageByAlias("88888888","sendMessageByAllToAlias");
	}

}
