package com.itel.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 推送信息实体Bean
 * @author yangxuan
 *
 */
@Entity
@Table(name="itel_sam_push")
public class SamPush implements Serializable{
	private static final long serialVersionUID = -190821482547490899L;
	@Id
	@Column(name="uid")
	private String uid;
	@Column(name="channel")
	private String channel;//Jpush注册id
	@Column(name="uitel")
	private String uitel;//Jpush Alias(itel号)
	@Column(name="type")
	private String type;//平台类型
	@Column(name="devicetype")
	private String devicetype;//设备类型(猫眼或监控)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getUitel() {
		return uitel;
	}
	public void setUitel(String uitel) {
		this.uitel = uitel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	
	
	

}
