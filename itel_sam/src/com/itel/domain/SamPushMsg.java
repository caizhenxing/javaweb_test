package com.itel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 推送消息保存记录实体Bean
 * @author yangxuan
 *
 */
@Entity
@Table(name="itel_sam_pushmsg")
public class SamPushMsg  implements Serializable{
	
	private static final long serialVersionUID = 2633177838004103090L;
	@Id
	@Column(name="uid")
	private String uid;
	@Column(name="pushtype")
	private String pushtype;//推送类型PUSH_Notification or PUSH_Message
	@Column(name="platform")
	private String platform;//推送平台Push_AllPlatForm or PUSH_IOSPlatForm or PUSH_AndroidPlatForm
	@Column(name="alltarget")
	private String alltarget;//推送对象-所有人
	@Column(name="alias")
	private String alias;//推送对象-别名
	@Column(name="registrationid")
	private String registrationid;//推送对象-注册ID
	@Column(name="title")
	private String title;//标题
	@Column(name="content")
	private String content;//内容
	@Column(name="msgtype")
	private String msgtype;//消息类型
	@Column(name="pubtime")
	private String pubtime;//推送时间
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPushtype() {
		return pushtype;
	}
	public void setPushtype(String pushtype) {
		this.pushtype = pushtype;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	 
	public String getAlltarget() {
		return alltarget;
	}
	public void setAlltarget(String alltarget) {
		this.alltarget = alltarget;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(String registrationid) {
		this.registrationid = registrationid;
	}
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
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	
	

}
