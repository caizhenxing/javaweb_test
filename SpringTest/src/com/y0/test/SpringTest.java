package com.y0.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.y0.service.impl.LoginService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test public void loginTest ()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		LoginService serv = (LoginService)ctx.getBean("loginService");
		serv.login();
	}
}
