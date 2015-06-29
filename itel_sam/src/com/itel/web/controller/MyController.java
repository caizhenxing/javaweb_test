package com.itel.web.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("myController")
public class MyController {
	@Test
	public void method(){
		double use = 20.9;
		double count = 32;
		System.out.println((use/count)*100);
		
		long a = (long) 20.9;
		long b = 32;
		double a1 = Double.parseDouble(a+"");
		double b1 = Double.parseDouble(b+"");
		System.out.println(a1);
		System.out.println(b1);
		System.out.println((a1/b1)*100);
	}
	
 
}
