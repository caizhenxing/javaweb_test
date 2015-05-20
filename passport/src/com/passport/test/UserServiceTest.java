package com.passport.test;


import java.util.Date;
import java.util.Set;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.passport.bean.Account;
import com.passport.bean.LevelInfo;
import com.passport.bean.LoginInfo;
import com.passport.bean.RegInfo;
import com.passport.service.UserRegService;

public class UserServiceTest {

	private static UserRegService regService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"config/appCtx.xml");
			regService = (UserRegService) context.getBean("regService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReg ()
	{
		Account user = new Account();
		user.setUserName("y0"+ new Date().toString());
		user.setNickName("y0");
		user.setPassword("admin");
		user.setEmail(new Date().toString() + "@163.com");
		
		RegInfo regInfo = new RegInfo();
		regInfo.setRegip("1.1.1.1");
		regInfo.setRegtime(new Date());
		
		LevelInfo levelInfo = new LevelInfo();
		levelInfo.setActiveday(1);
		levelInfo.setActivetime(new Date());
		levelInfo.setLevel(0);
		
		LoginInfo login1 = new LoginInfo();
		login1.setLogintime(new Date());
		login1.setAddress("1.2.3.4");
		login1.setSessiontoken("dsfgfvdhvjkflhduijdkfvf");
		
		LoginInfo login2 = new LoginInfo();
		login2.setLogintime(new Date());
		login2.setAddress("1.2.3.4");
		login2.setSessiontoken("dsfgfvdhvjkflhduijdkfvf");
		
		levelInfo.setAccount(user);
		user.setLevelInfo(levelInfo);
		user.setRegInfo(regInfo);
		regInfo.setAccount(user);
		
		Set<LoginInfo> list = user.getLoginInfos();
		list.add(login1);
		list.add(login2);
		
		regService.reg(user);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
