package com.itel.domain;

import java.io.Serializable;

/**
 * 推送消息Bean
 * @author yangxuan
 *
 */
public class PushMessage implements Serializable{
	private static final long serialVersionUID = -619900145876329687L;
	private String type;//推送通知还是消息
	private String platForm;//手机操作平台
	private String iosenv;//IOS环境
	private String channel;//极光推送中的注册id
	private String uitel;//与极光推送alias一致
	private String target;//是否发送给所有人
	private String title;//标题
	private String content;//内容
	private String msgType;//消息类型(系统消息.个人消息等等类型)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlatForm() {
		return platForm;
	}
	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}
	public String getUitel() {
		return uitel;
	}
	public void setUitel(String uitel) {
		this.uitel = uitel;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getIosenv() {
		return iosenv;
	}
	public void setIosenv(String iosenv) {
		this.iosenv = iosenv;
	}
	 
	
	
	

}
