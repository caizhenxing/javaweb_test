package com.y0.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.y0.bean.User;
import com.y0.service.UserService;

@Transactional
public class UserServiceBean implements UserService {

	@Resource private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#save(com.y0.bean.User)
	 */
	public void save(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		System.out.println("����һ���û�:"+ user.getUserName());
		currentSession.persist(user);
	}

	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#update(com.y0.bean.User)
	 */
	public void update(User user) {
		System.out.println("����һ���û�:"+ user.getUserName());
	}

	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#delete(java.lang.Integer)
	 */
	public void delete(Integer userID) {

		Session s = sessionFactory.getCurrentSession();
		System.out.println("ɾ��һ���û�:"+ userID);
		User user = this.query(userID);
		if (user == null) {
			
			System.out.println("Ҫɾ�����û�������");
			return;
		}
		s.delete(user);
	}

	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#query(java.lang.Integer)
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public User query(Integer userID) {
		
		Session s = sessionFactory.getCurrentSession();
		System.out.println("��ѯһ���û�:"+ userID);
		return (User) s.get(User.class, userID);
	}

	/* (non-Javadoc)
	 * @see com.y0.service.impl.UserService#userList()
	 */
	public List<User> userList() {
		System.out.println("��ѯ�û��б�:");
		return null;
	}
}
