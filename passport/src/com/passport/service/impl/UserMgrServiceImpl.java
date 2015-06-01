package com.passport.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.passport.bean.Account;
import com.passport.service.UserMgrService;

@Transactional
public class UserMgrServiceImpl implements UserMgrService {

	@Resource
	private SessionFactory sessionFactory;
	
	public boolean delete(Account user) {
		return false;
	}

	public boolean update(Account user) {
		return false;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Set<Account> userList(Integer page, Integer count) {
		return null;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Set<Account> userList() {
		return null;
	}

	/**
	 * 获取用户信息
	 */
	public Account getUser(String userName, int type) {
		
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Account where userName=:userName");
		q.setString("userName", userName);
		List l = q.list();
		return (Account) (l.size() > 0 ? l.get(0) : null);
	}
}
