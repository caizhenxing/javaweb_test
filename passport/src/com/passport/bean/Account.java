package com.passport.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account_basic", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"userName", "email" }) })
public class Account {

	@Id
	@Column(name = "user_id")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private int userId;
	private String userName;
	private String password;
	private String nickName;
	private String phone;
	private String email;
	private String qq;
	private String address;
	private String userGroup;
	private String permission;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "level_info_id")
	private LevelInfo levelInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reg_info_id")
	private RegInfo regInfo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Set<LoginInfo> loginInfos;
	
	@Transient
	private ArrayList<AuthorInfo> authorInfos;

	public Account() {

		authorInfos = new ArrayList<AuthorInfo>();
		loginInfos = new HashSet<LoginInfo>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
	}

	@Basic
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo levelInfo) {
		this.levelInfo = levelInfo;
	}

	public RegInfo getRegInfo() {
		return regInfo;
	}

	public void setRegInfo(RegInfo regInfo) {
		this.regInfo = regInfo;
	}

	public Set<LoginInfo> getLoginInfos() {
		return loginInfos;
	}

	public void setLoginInfos(Set<LoginInfo> loginInfos) {
		this.loginInfos = loginInfos;
	}

	public ArrayList<AuthorInfo> getAuthorInfos() {
		return authorInfos;
	}

	public void setAuthorInfos(ArrayList<AuthorInfo> authorInfos) {
		this.authorInfos = authorInfos;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
