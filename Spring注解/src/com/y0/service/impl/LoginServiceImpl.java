package com.y0.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.y0.service.LoginService;
import com.y0.service.dao.LoginDao;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginDao loginDao;

	/**
	 * ��½
	 */
	public void login(String name) {
		System.out.println("��½����");
		loginDao.verify();
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��");
	}

	@PreDestroy
	public void dealloc() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}
}
