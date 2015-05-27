package com.passport.service;

import java.util.Set;

import com.passport.bean.Account;

public interface UserMgrService {

	/// user permission manager 
	/// user author 
	

	/**
	 * 更新用户
	 */
	public abstract boolean update(Account user);
	
	/**
	 * 删除
	 * @param user
	 * @return
	 */
	public abstract boolean delete(Account user);
	
	/**
	 * 用户列表这是所有的
	 * @param page
	 * @param count
	 * @return
	 */
	public abstract Set<Account> userList(Integer page, Integer count);
	
	/**
	 * 用户列表
	 */
	public abstract Set<Account> userList();
	
	/**
	 * 获取用户
	 * User : 用户名,Email,手机号
	 * Type : 类型, 目前未使用,
	 */
	public Account getUser(String userName, int type);
	
}
