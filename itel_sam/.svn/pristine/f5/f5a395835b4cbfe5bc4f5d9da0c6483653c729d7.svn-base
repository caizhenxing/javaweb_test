package com.itel.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 设备授权实体Bean
 * @author yangxuan
 *
 */
@Entity
@Table(name="itel_sam_author")
public class SamAuthor implements Serializable{
	private static final long serialVersionUID = -923963495199855699L;
	@Id
	@Column(name="uid")
	private String uid;//主键
	@Column(name="var_pitel")
	private String varPitel;//设备itel号
	@Column(name="var_uitel")
	private String varUitel;//用户itel号
	@Column(name="var_backname")
	private String backName;//设备主人对绑定用户信息备注名
	@Column(name="var_devicename")
	private String deviceName;//授权信息(我的设备列表)对其他用户设备的别名
	@Column(name="date_time")
	private String dateTime;//增加时间(授权或绑定)
	@Column(name="active")
	private String active;//是否主动增加
	public String getVarPitel() {
		return varPitel;
	}
	public void setVarPitel(String varPitel) {
		this.varPitel = varPitel;
	}
	public String getVarUitel() {
		return varUitel;
	}
	public void setVarUitel(String varUitel) {
		this.varUitel = varUitel;
	}
 
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getBackName() {
		return backName;
	}
	public void setBackName(String backName) {
		this.backName = backName;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}
