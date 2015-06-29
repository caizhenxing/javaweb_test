package com.itel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 监控后台登入实体Bean
 * @author Administrator
 *
 */
@Entity
@Table(name="itel_sam_account")
public class LoginAccount implements Serializable{
	
	private static final long serialVersionUID = -5378643488636008231L;
	@Id
	@Column(name="uid")
	private String uid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="roletype")
	private String roletype;
	@Transient
	private String validateCode;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	
}
