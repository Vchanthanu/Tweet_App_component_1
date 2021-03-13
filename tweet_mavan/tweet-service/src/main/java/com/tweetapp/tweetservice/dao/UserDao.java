/**
 * 
 */
package com.tweetapp.tweetservice.dao;

import java.util.List;

import com.tweetapp.tweetservice.model.User;

/**
 * @author Chanthanu
 *
 */
public interface UserDao {

	/*
	 * Fetch all the Registered User
	 * 
	 * @return List of register users
	 */

	public List<User> getAllUser();

	/*
	 * To Register an User
	 * 
	 * @param User user detail of user for registering
	 */
	public void registerUser(User user);

	/*
	 * Used to check user exist or not
	 * 
	 * @param Stringemail entered by user for logging in
	 * 
	 * @return User detail
	 */
	public User userExist(String email_user);

	/*
	 * To update Logged Indicator while logging in and out
	 * 
	 * @param String ind Y - currently logged in N -currently not logged in
	 * 
	 * @param int userId id of the user
	 */
	public void updateLogInd(String ind, int userId);

	/*
	 * To update password
	 * 
	 * @param String password new password for updating
	 * 
	 * @param int userId id of the user
	 */
	public void updatePassword(int userId, String password);

	/*
	 * To find user by ind
	 * 
	 * @param String ind 
	 */
	public User getUserByInd(String ind);
	
}
