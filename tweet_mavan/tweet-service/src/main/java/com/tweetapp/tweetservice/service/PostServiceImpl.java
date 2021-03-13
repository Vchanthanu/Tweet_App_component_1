package com.tweetapp.tweetservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tweetapp.tweetservice.dao.PostDao;
import com.tweetapp.tweetservice.dao.PostDaoImpl;
import com.tweetapp.tweetservice.dao.UserDao;
import com.tweetapp.tweetservice.dao.UserDaoImpl;
import com.tweetapp.tweetservice.dto.PostDto;
import com.tweetapp.tweetservice.model.Post;
import com.tweetapp.tweetservice.model.User;

public class PostServiceImpl implements PostService {
	UserService userService = new UserServiceImpl();
	UserDao userDao = new UserDaoImpl();
	PostDao postDao = new PostDaoImpl();

	@Override
	public void postMenu() {
		System.out.println("Enter Your choice :");
		System.out.println("1. Post a Tweet");
		System.out.println("2. View my Tweet");
		System.out.println("3. View all Tweets");
		System.out.println("4. View all Users");
		System.out.println("5. Reset Password");
		System.out.println("6. Logout");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("!!! Post a Tweet !!!");
			addPost();
			break;
		case 2:
			getTweetByUser();
			break;
		case 3:
			getAllTweet();
			break;
		case 4:
			getAllUser();
			break;
		case 5:
			userService.resetPassword();
			break;
		case 6:
			userService.logout();
			break;
		default:
			System.out.println("Please enter a vaild choice");
			postMenu();
		}
		sc.close();
	}

	@Override
	public void addPost() {
		System.out.println("Enter the tweet description:");
		Scanner sc = new Scanner(System.in);
		String desc = sc.nextLine();
		User user = userDao.getUserByInd("Y");
		Post post = new Post(desc, user.getId());
		postDao.addTweet(post);
		System.out.println("Tweet posted Successfully");
		postMenu();
	}

	@Override
	public void getTweetByUser() {
		User user = userDao.getUserByInd("Y");
		List<Post> tweets = postDao.getAllTweetByUser(user.getId());
		for (Post tweet : tweets) {
			System.out.println(tweet);
		}
		postMenu();
	}

	@Override
	public void getAllTweet() {
		List<PostDto> tweets = postDao.getAllTweet();
		for (PostDto tweet : tweets) {
			System.out.println(tweet);
		}
		postMenu();
	}

	@Override
	public void getAllUser() {
		List<User> users = userDao.getAllUser();
		for (User user : users) {
			System.out.println(user);
		}
		postMenu();
	}

}
