package com.y0.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.y0.bean.User;
import com.y0.service.UserService;


@Controller
@RequestMapping("/user")
public class UserAction {

	/**
	 * �û�ҵ��bean
	 */
	@Resource private UserService userService;
	
	/**
	 * �û��б�
	 * @param req ����
	 * @param rsp ��Ӧ
	 * @return ��ͼ����
	 */
	@RequestMapping("/list")
	public String users(HttpServletRequest req, HttpServletResponse rsp) {
		List<User> user = userService.userList();
		req.setAttribute("users", user);
		return "WEB-INF/page/list";
	}
	
	/**
	 * ��½��ͼ
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("/regView") 
	public String loginView(HttpServletRequest req, HttpServletResponse rsp) {
		
		return "WEB-INF/page/add";
	}
	
	/**
	 * ɾ���û�
	 * @param id
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("/del") 
	public String del(HttpServletRequest req, HttpServletResponse rsp) {
		
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		userService.delete(id);
		System.out.println("del complete !");
		req.setAttribute("msg", "del success !");
		return "WEB-INF/page/msg";
	}
	
	/**
	 *	ע���û�
	 * @param id
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("/reg") 
	public String reg(User user, HttpServletRequest req, HttpServletResponse rsp) {
		
		System.out.println("will addition NickName!" + user.getNickName());
		userService.save(user);
		
		req.setAttribute("msg", "addition success !");
		return "WEB-INF/page/msg";
	}
	
}
