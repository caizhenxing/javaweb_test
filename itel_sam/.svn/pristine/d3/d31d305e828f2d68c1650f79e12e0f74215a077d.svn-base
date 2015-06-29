package com.itel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itel.dao.LoginAccountDao;
import com.itel.domain.LoginAccount;
import com.itel.service.LoginAccountService;
@Service
public class LoginAccountServiceImpl implements LoginAccountService {
	
	@Autowired
	private LoginAccountDao loginAccountDao;

	@Override
	public LoginAccount submitLogin(LoginAccount loginAccount) {
		return loginAccountDao.queryloginAccount(loginAccount);
	}

}
