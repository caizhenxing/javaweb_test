package com.y0.bean;

import com.y0.formbean.UserForm;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User {
	
	private int id;
	private String userName;
	private String password;
	private String nickName;
	private String email;
	private String phoneNum;
	
	public User() {
	}
	
	public User(UserForm userForm) {
		
		this.userName = userForm.getUsername();
		this.password = userForm.getPassword();
		this.nickName = userForm.getNickname();
		this.phoneNum = userForm.getPhonenum();
		this.email = userForm.getEmail();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
