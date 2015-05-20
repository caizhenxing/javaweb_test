package com.passport.service;

import com.passport.bean.Account;

/**
 * Login
 * @author Administrator
 *
 */
public interface UserLoginService {

	/// login
	public abstract Account login(String userName);
}
