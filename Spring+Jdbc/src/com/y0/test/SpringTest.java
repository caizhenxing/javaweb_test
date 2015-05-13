package com.y0.test;




import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.y0.model.UserModel;
import com.y0.service.LoginService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test public void users ()
	{

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		LoginService serv = (LoginService)ctx.getBean("loginService");
		serv.userList();
		ctx.close();
	}
	
	@Test public void loginTest ()
	{

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		LoginService serv = (LoginService)ctx.getBean("loginService");
		serv.login("—Ó‘∂¡÷", "");
		ctx.close();
	}

}
