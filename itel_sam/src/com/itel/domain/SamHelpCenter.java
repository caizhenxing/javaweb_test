package com.itel.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 帮助中心实体Bean
 * @author yangxuan
 *
 */
@Entity
@Table(name="itel_sam_helpcenter")
public class SamHelpCenter implements Serializable{
	private static final long serialVersionUID = -3330545833280014456L;
	@Id
	@Column(name="uid")
	private int uid;//主键
	@Column(name="title")
	private String title;//标题
	@Column(name="content")
	private String content;//内容
	@Column(name="type")
	private String type;//平台,IOS,Android
	@Column(name="version")
	private String version;//版本
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
