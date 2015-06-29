package com.itel.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 版本信息实体Bean
 * @author yangxuan
 *
 */
@Entity
@Table(name="itel_sam_upgrade")
public class SamUpgrade implements Serializable{
	private static final long serialVersionUID = 7680836299861385722L;
	@Id
	@Column(name="upgradeId")
	private String upgradeId;
	@Column(name="name")
	private String name;//版本名称
	@Transient
	private String androidurl;
	@Transient
	private String iosurl;
	@Column(name="url")
	private String url;//源地址(IOS为Store地址,Android为本地地址)
	@Column(name="platform")
	private String platform;//设备平台(IOS或Android)
	@Column(name="decription")
	private String decription;//描述
	@Column(name="required")
	private String required;//是否是硬更新
	@Column(name="pubtime")
	private String pubtime;//发布时间
	@Column(name="version")
	private String version;//版本号
	public String getUpgradeId() {
		return upgradeId;
	}
	public void setUpgradeId(String upgradeId) {
		this.upgradeId = upgradeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getAndroidurl() {
		return androidurl;
	}
	public void setAndroidurl(String androidurl) {
		this.androidurl = androidurl;
	}
	public String getIosurl() {
		return iosurl;
	}
	public void setIosurl(String iosurl) {
		this.iosurl = iosurl;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	 
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
	

}
