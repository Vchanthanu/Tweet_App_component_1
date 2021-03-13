/**
 * 
 */
package com.tweetapp.tweetservice.service;

/**
 * @author Chanthanu
 *
 */
public interface UserService {

	/*
	 * User menu used for navigating nonLogedin users
	 * 
	 * @Options 1.Login User 2.Forget Password 3.Register User
	 */
	public void userMenu();

	/*
	 * Logging user by getting email and password
	 */
	public void login();

	/*
	 * Log off user
	 */
	public void logout();

	/*
	 * Register user by getting user details
	 */
	public void registerUser();

	/*
	 * Changing password when user forgets the password
	 */
	public void forgotPassword();
	/*
	 * Reset password by checking 
	 */
	public void resetPassword();

}
