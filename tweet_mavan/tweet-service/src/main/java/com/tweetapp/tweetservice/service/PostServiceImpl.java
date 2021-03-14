package com.tweetapp.tweetservice.service;

import java.util.List;
import java.util.Scanner;

import com.tweetapp.tweetservice.dao.PostDao;
import com.tweetapp.tweetservice.dao.PostDaoImpl;
import com.tweetapp.tweetservice.dao.UserDao;
import com.tweetapp.tweetservice.dao.UserDaoImpl;
import com.tweetapp.tweetservice.dto.PostDto;
import com.tweetapp.tweetservice.model.Post;
import com.tweetapp.tweetservice.model.User;

/**
 * @author Chanthanu
 *
 */
public class PostServiceImpl implements PostService {
	UserService userService = new UserServiceImpl();
	UserDao userDao = new UserDaoImpl();
	PostDao postDao = new PostDaoImpl();

	@Override
	public void postMenu() {
		System.out.println();
		System.out.println("Enter Your choice :");
		System.out.println("1. Post a Tweet");
		System.out.println("2. View my Tweet");
		System.out.println("3. View all Tweets");
		System.out.println("4. View all Users");
		System.out.println("5. Reset Password");
		System.out.println("6. Logout");
		Scanner sc = new Scanner(System.in);
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Invaild Input");
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
		System.out.println();
		User user = userDao.getUserByInd("Y");
		List<Post> tweets = postDao.getAllTweetByUser(user.getId());
		System.out.println("Tweets posted by " + user.getFirstName());
		if (tweets.isEmpty()) {
			System.out.println("--- No Tweet ---");
		} else {
			for (Post tweet : tweets) {
				System.out.println(tweet);
			}
		}
		postMenu();
	}

	@Override
	public void getAllTweet() {
		System.out.println();
		System.out.println("All Tweets posted by all user ");
		List<PostDto> tweets = postDao.getAllTweet();
		if (tweets.isEmpty()) {
			System.out.println("--- No Tweet ---");
		} else {
			for (PostDto tweet : tweets) {
				System.out.println(tweet);
			}
		}
		postMenu();
	}

	@Override
	public void getAllUser() {
		System.out.println();
		System.out.println("All users");
		List<User> users = userDao.getAllUser();
		if (users.isEmpty()) {
			System.out.println("--- No Users ---");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		postMenu();
	}

}
