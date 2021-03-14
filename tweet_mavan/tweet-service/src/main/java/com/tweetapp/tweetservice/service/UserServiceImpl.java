package com.tweetapp.tweetservice.service;

import java.util.Scanner;

import com.tweetapp.tweetservice.dao.UserDao;
import com.tweetapp.tweetservice.dao.UserDaoImpl;
import com.tweetapp.tweetservice.model.User;

/**
 * @author Chanthanu
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void userMenu() {
		System.out.println();
		System.out.println("Enter Your choice :");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Forgot Password");
		Scanner sc = new Scanner(System.in);
		try {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("!!! Login !!!");
				login();
				break;
			case 2:
				System.out.println();
				System.out.println("!!! Register !!!");
				registerUser();
				break;
			case 3:
				System.out.println();
				System.out.println("!!! Forgot Password !!!");
				forgotPassword();
				break;
			default:
				System.out.println("Please enter a vaild choice");
				userMenu();
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
			userMenu();
		}

		sc.close();
	}

	@Override
	public void login() {
		Scanner sc = new Scanner(System.in);
		String email = getEmail(sc);
		System.out.println("Enter the password:");
		String password = sc.nextLine();
		UserDao userDao = new UserDaoImpl();
		User user = userDao.userExist(email);
		if (user != null) {
			if (password.contentEquals(user.getPassword())) {
				userDao.updateLogInd("Y", user.getId());
				System.out.println("Logged in Successfully");
				PostService post = new PostServiceImpl();
				post.postMenu();
			} else {
				System.out.println("Invalid password");
				System.out.println(" Enter email and password again");
				login();
			}
		} else {
			System.out.print("Invalid email id");
			System.out.println(" Enter email and password again");
			login();
		}
	}

	@Override
	public void registerUser() {
		Scanner sc = new Scanner(System.in);
		String email = getEmail(sc);
		System.out.println("Enter the first name :");
		String firstName = sc.nextLine();
		String gender = getGender(sc);
		System.out.println("Enter the password:");
		sc.nextLine();
		String password = sc.nextLine();
		User user = new User(firstName, gender, email, password, false);
		UserDao userDao = new UserDaoImpl();
		User userExist = userDao.userExist(email);
		if (userExist == null) {
			userDao.registerUser(user);
			System.out.println("User Registered Successfully");
			userMenu();
		} else {
			System.out.println("User already exist");
			userMenu();
		}

	}

	@Override
	public void forgotPassword() {
		Scanner sc = new Scanner(System.in);
		String email = getEmail(sc);
		UserDao userDao = new UserDaoImpl();
		User userExist = userDao.userExist(email);
		if (userExist == null) {
			System.out.println("Invaild Email..");
			userMenu();
		} else {
			System.out.println("Enter new Password");
			String newPassword = sc.nextLine();
			userDao.updatePassword(userExist.getId(), newPassword);
			System.out.println("Password Updated !!! ");
			userMenu();
		}

	}

	@Override
	public void logout() {
		UserDao userDao = new UserDaoImpl();
		User loggedInUser = userDao.getUserByInd("Y");
		userDao.updateLogInd("N", loggedInUser.getId());
		System.out.println("Successfully Logged Out");
		userMenu();
	}

	@Override
	public void resetPassword() {
		UserDao userDao = new UserDaoImpl();
		User loggedInUser = userDao.getUserByInd("Y");
		System.out.println("Enter the old Password");
		Scanner sc = new Scanner(System.in);
		String oldPassword = sc.nextLine();
		PostService post = new PostServiceImpl();
		if (oldPassword.contentEquals(loggedInUser.getPassword())) {
			System.out.println("Enter the new password : ");
			String newPassword = sc.nextLine();
			userDao.updatePassword(loggedInUser.getId(), newPassword);
			System.out.println("Password Updated !!! ");
			post.postMenu();
		} else {
			System.out.print("Invalid Old password");
			post.postMenu();
		}
		sc.close();
	}

	public String getEmail(Scanner sc) {
		System.out.println("Enter the email id :");
		String email = sc.nextLine();
		if (email.contains("@")) {
			return email;
		} else {
			System.out.println("InVaild Email");
			return getEmail(sc);
		}
	}

	public String getGender(Scanner sc) {
		System.out.println("Enter the gender :");
		System.out.println("1.Male");
		System.out.println("2.Female");
		System.out.println("3.Other");
		int choice;
		try {
			choice = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid Input");
			return getEmail(sc);
		}
		switch (choice) {
		case 1:
			return "M";
		case 2:
			return "F";
		case 3:
			return "O";
		default:
			System.out.println("Invaild input");
			return getEmail(sc);
		}
	}

}
