package com.passport.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="login_info")
public class LoginInfo {
	
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private int id;
	
	@Transient
	private Account account;
	private String address;
	private String host;
	private Date logintime;
	private Date logouttime;
	private String sessiontoken;
	
	@Transient
	private AuthorInfo authorInfo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public Date getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}
	public String getSessiontoken() {
		return sessiontoken;
	}
	public void setSessiontoken(String sessiontoken) {
		this.sessiontoken = sessiontoken;
	}
	public AuthorInfo getAuthorInfo() {
		return authorInfo;
	}
	public void setAuthorInfo(AuthorInfo authorInfo) {
		this.authorInfo = authorInfo;
	}

}

