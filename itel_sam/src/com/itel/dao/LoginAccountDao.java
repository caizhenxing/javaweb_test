package com.itel.dao;

import com.itel.domain.LoginAccount;

/**
 * 监控后台验证Dao
 * @author yangxuan
 *
 */
public interface LoginAccountDao {
	
	/**
	 * 校验账号合法性
	 * @param loginAccount
	 * @return
	 */
	public LoginAccount queryloginAccount(LoginAccount loginAccount);
}
