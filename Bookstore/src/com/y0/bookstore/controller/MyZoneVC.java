package com.y0.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MyZoneVC extends MultiActionController {

	public ModelAndView myinfo(HttpServletRequest req, HttpServletResponse rep) {
		
		System.out.println("�ҵ���Ϣ����,����");
		return new ModelAndView("MyZone");
	}
}
