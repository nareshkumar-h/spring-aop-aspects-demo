package com.naresh.service;

public class UserService {

	public void addUser(){
		System.out.println("UserService->addUser");
	}
	
	public String addUserReturnValue(){
		System.out.println("UserService->addUserReturnValue" );
		return "test";
	}
	
	public void addUserThrowException() throws Exception {
		System.out.println("UserService->addUserThrowException() ");
		throw new Exception("Generic Error");
	}
	
	public void addUserAround(String name){
		System.out.println("UserService->addUserAround() is running, args : " + name);
	}
}
