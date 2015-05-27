package com.passport.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.passport.service.UserProvService;

@Controller
@RequestMapping("/register")
public class UserRegController {

	@Resource private UserProvService provService;
	/**
	 * зЂВс
	 * @return
	 */
	@RequestMapping("/reg")
	public String reg (HttpServletRequest req, HttpServletResponse resp)
	{
		this.provService.reg(null);
		return "msg";
	}
}
