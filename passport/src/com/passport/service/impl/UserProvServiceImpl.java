package com.passport.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.passport.bean.Account;
import com.passport.service.UserProvService;

@Transactional
public class UserProvServiceImpl implements UserProvService {

	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public Account login_email(String email, String psw) {
		
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Account where email=:email");
		q.setString("email", email);
		List<Account> l = q.list();
		Account user = l.get(0);
		if (user.getPassword().equals(psw)) {
			return user;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Account login_general(String userName, String psw) {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Account where userName=:userName");
		q.setString("userName", userName);
		List<Account> l = q.list();
		if (l.size() < 1) {
			
			return null;
		}
		Account user = l.get(0);
		if (user.getPassword().equals(psw)) {
			return user;
		}
		return null;
	}

	public Account login_session(String userName, String sessionToken) {
		return null;
	}
	
	public boolean bathchReg(List<Account> users) {
		boolean ret = true;
		System.out.println("batch register " + users.size());
		Session s = sessionFactory.getCurrentSession();
		for (Account user : users) {
			s.persist(user);
		}
		return ret;
	}

	public boolean reg(Account user) {
		boolean ret = true;
		System.out.println("user register " + user.getUserName());
		Session s = sessionFactory.getCurrentSession();
		
		try {
			s.persist(user);
		} catch (ConstraintViolationException e) {
			
			System.out.println("Œ•∑¥‘º ¯“Ï≥£");
			//e.printStackTrace();
			ret = false;
		} finally {
			
		}
		return ret;
	}
}
