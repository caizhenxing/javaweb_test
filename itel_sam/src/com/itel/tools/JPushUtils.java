package com.itel.tools;

import java.util.Random;

import com.sun.security.ntlm.Client;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.audience.Audience.Builder;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;

/**
 * 极光推送公共类
 * 
 * @author yangxuan
 * 
 */
public class JPushUtils {
	
	/**
	 * applicationContext.xml注入client,以便通过配置文件修改推送app
	 */
	private JPushClient client;
	 
	 
	public JPushClient getClient() {
		return client;
	}
	public void setClient(JPushClient client) {
		this.client = client;
	}
	
	
	public PushResult sendMsg(PushPayload pushPayload){
		PushResult result = client.sendPush(pushPayload);
		return result;
	}
	
	public void sendMsgByPerson(String regId,String msg ){
		 Audience audience = Audience.registrationId(regId);
		 PushPayload.Builder p = PushPayload.newBuilder();
		 p.setAudience(audience);
		 p.setPlatform(Platform.android());
		 Notification notification = Notification.alert(msg);
		 p.setNotification(notification);
		 PushPayload pp =  p.build();
		 PushResult result = client.sendPush(pp);
		 System.out.println(result.isResultOK());
	}
	
	/**
	 * windows Phone ,IOS,Android 推送消息
	 * @param str
	 */
	public void sendMessageByAll(String str){
		Audience audience = Audience.all();
		PushPayload.Builder p = PushPayload.newBuilder();
		p.setAudience(audience);
		p.setPlatform(Platform.all());
		Message message = Message.content(str);
		p.setMessage(message);
		PushPayload pp =  p.build();
		client.sendPush(pp);
	}
	
	/**
	 * Android 推送消息
	 * @param str
	 */
	public void sendMessageByAllToAndroid(String str){
		Audience audience = Audience.all();
		PushPayload.Builder p = PushPayload.newBuilder();
		p.setAudience(audience);
		p.setPlatform(Platform.android());
		Message message = Message.content(str);
		p.setMessage(message);
		PushPayload pp =  p.build();
		client.sendPush(pp);
	}
	
	/**
	 * IOS 推送消息
	 * @param str
	 */
	public void sendMessageByAllToIOS(String str){
		Audience audience = Audience.all();
		PushPayload.Builder p = PushPayload.newBuilder();
		p.setAudience(audience);
		p.setPlatform(Platform.ios());
		Message message = Message.content(str);
		p.setMessage(message);
		PushPayload pp =  p.build();
		client.sendPush(pp);
	}
	
	
	public void sendMessageByAlias(String alias,String msg){
//		Audience audience = Audience.alias("88888888");
		Audience audience = Audience.alias(alias);
		PushPayload.Builder p = PushPayload.newBuilder();
		p.setAudience(audience);
		p.setPlatform(Platform.all());
		Message message = Message.content(msg);
		p.setMessage(message);
		PushPayload pp =  p.build();
		client.sendPush(pp);
	}
	
	
	public static void IOSPushNotication(){
		JPushClient jPushClient = new JPushClient("bfa29d1a23557cea8aa2c221", "3259f0dbb3b30b010de8e25f");
		PushPayload.Builder builder = PushPayload.newBuilder();
		
		
		Notification.Builder noBuilder = Notification.newBuilder();
		IosNotification iosNotification = IosNotification.alert("dasdojaslkdsa");
		AndroidNotification androidNotification = AndroidNotification.alert("dasdojaslkdsa");
		noBuilder.addPlatformNotification(iosNotification);
		noBuilder.addPlatformNotification(androidNotification);
		Notification notification = noBuilder.build();
		builder.setNotification(notification);
		
		Audience audience = Audience.all();
		builder.setAudience(audience);
		
		
		builder.setPlatform(Platform.all());
		
		
		Options.Builder optionsBuilder = Options.newBuilder();
		optionsBuilder.setApnsProduction(false);
		optionsBuilder.setTimeToLive(100000);
		try {
			optionsBuilder.setSendno(Random.class.newInstance().nextInt(1000000));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Options options = optionsBuilder.build();
		builder.setOptions(options);
		
		PushResult pushResult =jPushClient.sendPush(builder.build());
		System.out.println(pushResult.isResultOK());
		System.out.println(pushResult.getErrorMessage());
	}
	
	public static void main(String[] args){
		
		/*JPushClient jPushClient = new JPushClient("bfa29d1a23557cea8aa2c221", "3259f0dbb3b30b010de8e25f",false,10000000);
		PushPayload.Builder builder = PushPayload.newBuilder();
		Notification notification = Notification.alert("add apns_production");
		Notification.Builder noBuilder = Notification.newBuilder();
		IosNotification iosNotification = IosNotification.alert("dasdojaslkdsa");
		noBuilder.addPlatformNotification(iosNotification);
		builder.setNotification(notification);
		Audience audience = Audience.all();
		builder.setAudience(audience);
		Options.Builder optionsBuilder = Options.newBuilder();
		optionsBuilder.setApnsProduction(true);
		Options options = optionsBuilder.build();
		builder.setOptions(options);
		builder.setPlatform(Platform.all());
		PushPayload pushPayload = builder.build();
		PushResult pushResult = jPushClient.sendPush(pushPayload);
		System.out.println(pushResult.isResultOK());
		System.out.println(pushResult.getErrorMessage());*/
		
		
	
		IOSPushNotication();	
	
	}
	

}
