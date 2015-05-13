package com.y0.service;

import java.util.List;

import com.y0.bean.User;

public interface UserService {

	public abstract void save(User user);

	public abstract void update(User user);

	public abstract void delete(Integer userID);

	public abstract User query(Integer userID);

	public abstract List<User> userList();

}