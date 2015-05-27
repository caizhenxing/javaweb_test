package com.passport.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.passport.bean.Account;
import com.passport.service.UserProvService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Resource private UserProvService loginService;
	
	@RequestMapping("/login")
	public String login(Account user, HttpServletRequest req, HttpServletResponse resp) {
		
		Account u = loginService.login_general(user.getUserName(), user.getPassword());
		req.setAttribute("user", u);
		return "index";
	}
}
