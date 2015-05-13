package com.y0.test;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.y0.bean.User;
import com.y0.service.UserService;

public class UserServiceTest {

	private static UserService uServ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		uServ = (UserService) context.getBean("userService");
	}

	@Test
	public void testSave()
	{
		User user = new User();
		user.setUserName("小");
		
		uServ.add(user);
	}
	
	@Before
	public void setUp() throws Exception {
	}

}
