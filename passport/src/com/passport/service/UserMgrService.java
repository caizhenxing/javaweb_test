package com.passport.service;

import java.util.Set;

import com.passport.bean.Account;

public interface UserMgrService {

	/// user permission manager 
	/// user author 
	

	/**
	 * �����û�
	 */
	public abstract boolean update(Account user);
	
	/**
	 * ɾ��
	 * @param user
	 * @return
	 */
	public abstract boolean delete(Account user);
	
	/**
	 * �û��б��������е�
	 * @param page
	 * @param count
	 * @return
	 */
	public abstract Set<Account> userList(Integer page, Integer count);
	
	/**
	 * �û��б�
	 */
	public abstract Set<Account> userList();
	
	/**
	 * ��ȡ�û�
	 * User : �û���,Email,�ֻ���
	 * Type : ����, Ŀǰδʹ��,
	 */
	public Account getUser(String userName, int type);
	
}
