package com.passport.test;

import java.util.Date;
import java.util.Random;
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
import com.passport.service.UserProvService;
import com.passport.service.UserMgrService;

public class UserServiceTest {

	private static UserProvService provService;
	private static UserMgrService mgrService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"config/beans.xml");
			provService = (UserProvService) context.getBean("provService");
			mgrService = (UserMgrService) context.getBean("mgrService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReg ()
	{
		Account user = new Account();
		user.setUserName("y0"+ new Random().nextInt()%1000);
		user.setNickName("y0");
		user.setPassword("admin");
		user.setEmail("y0" + new Random().nextInt()%1000 + "@163.com");
		
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
		
		provService.reg(user);
	}
	
	@Test
	public void testEmailLogin ()
	{
		Account user = provService.login_email("y0love@163.com","s");
		if (user == null) {
			System.out.println("用户不存在");
			return;
		}
	}
	
	@Test
	public void testGetUser ()
	{
		Account user = mgrService.getUser("y0-76", 0);
		if (user == null) {
			System.out.println("用户不存在");
			return;
		}
		System.out.println("取到的用户 : " + user.getUserName());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

}
