/**
 * 
 */
package com.tweetapp.tweetservice.service;

import java.util.List;

import com.tweetapp.tweetservice.model.Post;

/**
 * @author Chanthanu
 *
 */
public interface PostService {
	/*
	 * Post menu used for navigating after logged in
	 * 
	 * @Options 1.View all Tweet 2.View my Tweet 3.View all users 4.Reset password
	 * 5.Logout
	 */
	public void postMenu();

	/*
	 * posting Tweet
	 */
	public void addPost();

	/*
	 * Get all tweet of user
	 */
	public void getTweetByUser();

	/*
	 * Get all Tweets
	 */
	public void getAllTweet();

	/*
	 * Get all registered users
	 */
	public void getAllUser();

}
