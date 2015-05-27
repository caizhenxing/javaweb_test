package com.passport.service;

import java.util.List;

import com.passport.bean.Account;

/**
 * Login Service
 * @author Administrator
 *
 */
public interface UserProvService {

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
	
	/**
	 * login general
	 * @param user
	 * @return error code
	 */
	public abstract Account login_general (String userName, String psw);
	
	/**
	 * email
	 * @param user
	 * @return  error code
	 */
	public abstract Account login_email (String email, String psw);
	
	/**
	 * session token
	 * @param email
	 * @return
	 */
	//public abstract Account login_session (String userName, String sessionToken);
}
