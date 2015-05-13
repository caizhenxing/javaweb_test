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
	 * 用户列表
	 * @return 视图名字
	 */
	public String list ()
	{
		this.users = userService.userList();
		System.out.println("用户列表");
		return "list";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String add () 
	{
		if (user == null) {
			this.msg = "失败";
			return "msg";
		}
		/// 
		this.user.setId(0);
		userService.save(this.user);
		this.msg = "成功";
		return "msg";
	}
	
	/**
	 * 用户登陆
	 * @return
	 */
	public String login() {
		
		User tmpUser = userService.query(user.getUserName());
		if (tmpUser == null) {
			
			this.msg = "用户不存在";
			return "login";
		}
		if (!this.user.getPassword().equals(tmpUser.getPassword())) {
			
			this.msg = "密码不正确";
			return "login";
		}
		this.msg = "登陆成功";
		this.user = tmpUser;
		return "detail";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String del ()
	{
		userService.delete(user.getId());
		System.out.println("删除成功");
		this.msg = "删除成功";
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
