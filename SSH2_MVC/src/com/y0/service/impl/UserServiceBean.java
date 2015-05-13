package com.y0.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.y0.bean.User;
import com.y0.service.UserService;

@Transactional
public class UserServiceBean implements UserService {

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.y0.service.impl.UserService#save(com.y0.bean.User)
	 */
	public void save(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.persist(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.y0.service.impl.UserService#update(com.y0.bean.User)
	 */
	public void update(User user) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.y0.service.impl.UserService#delete(java.lang.Integer)
	 */
	public void delete(Integer userID) {

		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("delete from User where id=?");

		// 跟据条件生成HQL语句
		query.setInteger(0, userID);// 设定条件参数
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.y0.service.impl.UserService#query(java.lang.Integer)
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User query(Integer userID) {

		Session s = sessionFactory.getCurrentSession();
		return (User) s.get(User.class, userID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.y0.service.impl.UserService#userList()
	 */
	public List<User> userList() {

		Session s = sessionFactory.getCurrentSession();
		List<User> users = s.createQuery("from User").list();
		return users;
	}

	public User query(String userName) {

		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from User where userName=:name");
		q.setString("name", userName);

		List<User> users = q.list();
		return users.size() == 0 ? null : users.get(0);
	}
}
