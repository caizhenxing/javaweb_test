package com.y0.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts.action.Action;

import com.y0.bean.User;
import com.y0.service.UserService;

public class UserMgrAction extends Action {
	
	@Resource UserService userService;
	private List<User> users;
	private String msg;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/**
	 * �û��б�
	 * @return ��ͼ����
	 */
	public String list ()
	{
		this.users = userService.userList();
		System.out.println("�û��б�");
		return "list";
	}
	
	/**
	 * ����û�
	 * @return
	 */
	public String add () 
	{
		if (user == null) {
			this.msg = "ʧ��";
			return "msg";
		}
		/// 
		this.user.setId(0);
		userService.save(this.user);
		this.msg = "�ɹ�";
		return "msg";
	}
	
	/**
	 * �û���½
	 * @return
	 */
	public String login() {
		
		User tmpUser = userService.query(user.getUserName());
		if (tmpUser == null) {
			
			this.msg = "�û�������";
			return "login";
		}
		if (!this.user.getPassword().equals(tmpUser.getPassword())) {
			
			this.msg = "���벻��ȷ";
			return "login";
		}
		this.msg = "��½�ɹ�";
		this.user = tmpUser;
		return "detail";
	}
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public String del ()
	{
		userService.delete(user.getId());
		System.out.println("ɾ���ɹ�");
		this.msg = "ɾ���ɹ�";
		return "msg";
	}
	
	public String addview ()
	{
		return "addview";
	}
	public String loginview ()
	{
		return "login";
	}
}
