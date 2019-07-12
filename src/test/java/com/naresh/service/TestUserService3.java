package com.naresh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService3 {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService accountDAO = ctx.getBean("userService", UserService.class);
		accountDAO.addUserAround("naresh");
	}
}
