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

	public void addPost();

	public void getTweetByUser();

	public void getAllTweet();

	public void getAllUser();

}
