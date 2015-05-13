package com.y0.test;



import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.y0.bean.User;
import com.y0.service.UserService;

public class UserServiceBeanTest {

	private static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");
			userService = (UserService) context.getBean("userService");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSave() {
		
		User user1 = new User();
		user1.setNickName("Ð¡Àû");
		user1.setUserName("yangyuanlin");
		user1.setPassword("admin");
		userService.save(user1);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {

		userService.delete(2);
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserList() {
		fail("Not yet implemented");
	}

}
