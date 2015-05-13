package com.y0.service;

import java.util.List;

import com.y0.model.UserModel;

public interface LoginService {

	public UserModel login(String name, String psw);
	
	public void register(UserModel model);
	
	public List<UserModel> userList ();
}