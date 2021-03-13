package com.tweetapp.tweetservice;

import com.tweetapp.tweetservice.service.UserService;
import com.tweetapp.tweetservice.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("!!! Welcome to Tweet App !!!");
		UserService userLog = new UserServiceImpl();
		userLog.userMenu();
	}
}
