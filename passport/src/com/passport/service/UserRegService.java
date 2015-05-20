package com.passport.service;

import java.util.List;

import com.passport.bean.Account;

/**
 * user register service
 * @author Administrator
 *
 */
public interface UserRegService {

	/**
	 * user register
	 * @param user
	 */
	public abstract boolean reg(Account user);
	
	/**
	 * bathch register(enterprise)
	 * @param users
	 */
	public abstract boolean bathchReg(List<Account> users);
}
