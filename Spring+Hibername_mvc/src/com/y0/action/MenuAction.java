package com.y0.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuAction {

	@RequestMapping("/menu")
	public String menus(HttpServletRequest req, HttpServletResponse rsp) {
		
		System.out.println("����˵�");
		req.setAttribute("aaa", "����˵�");
		return "WEB-INF/page/msg";
	}
}
