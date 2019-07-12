package com.naresh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService accountDAO = ctx.getBean("userService", UserService.class);
		accountDAO.addUser();
	}
}
