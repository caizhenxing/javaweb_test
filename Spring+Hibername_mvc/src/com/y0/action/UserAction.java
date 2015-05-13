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
	@RequestMapping("userList")
	public ModelAndView name(HttpServletRequest req, HttpServletResponse rsp) {
		List<User> user = userService.userList();
		req.setAttribute("user", user);
		return new ModelAndView("WEB-INF/user");
	}
	
	public String login() {
		
		return "list";
	}
}
