package com.y0.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginVC {

	@RequestMapping("/t")
	public ModelAndView test(HttpServletRequest req, HttpServletResponse rsp) {
		
		try {
			rsp.getWriter().write("这是参数");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("注解测试到达"+ req.getParameter("p"));
		return new ModelAndView("index");
	}
}
