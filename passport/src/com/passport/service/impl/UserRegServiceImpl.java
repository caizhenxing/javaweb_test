package com.passport.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.passport.bean.Account;
import com.passport.service.UserRegService;

@Transactional
public class UserRegServiceImpl implements UserRegService {

	@Resource
	private SessionFactory sessionFactory;

	
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
			e.printStackTrace();
			ret = false;
		} finally {
			
		}
		return ret;
	}
}
