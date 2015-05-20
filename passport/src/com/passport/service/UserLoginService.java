package com.passport.service;

import com.passport.bean.Account;

/**
 * Login Service
 * @author Administrator
 *
 */
public interface UserLoginService {

	/**
	 * login general
	 * @param user
	 * @return error code
	 */
	public abstract Account login_general (String userName);
	
	/**
	 * email
	 * @param user
	 * @return  error code
	 */
	public abstract Account login_email (String email);
	
	/**
	 * session token
	 * @param email
	 * @return
	 */
	public abstract Account login_session (String sessionToken);
}
