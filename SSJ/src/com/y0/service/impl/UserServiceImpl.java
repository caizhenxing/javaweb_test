package com.y0.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.y0.bean.User;
import com.y0.service.UserService;

public class UserServiceImpl implements UserService {

	@PersistenceContext EntityManager eManager;
	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#add(com.y0.bean.User)
	 */
	public void add(User user) {
		
		eManager.persist(user);
	}
}
