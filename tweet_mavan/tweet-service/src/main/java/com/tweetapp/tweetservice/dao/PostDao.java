package com.tweetapp.tweetservice.dao;

import java.util.List;

import com.tweetapp.tweetservice.dto.PostDto;
import com.tweetapp.tweetservice.model.Post;

/**
 * @author Chanthanu
 *
 */

public interface PostDao {

	/*
	 * To fetch all the Tweet
	 * 
	 * @ return list of Tweet posted by all user
	 */
	public List<PostDto> getAllTweet();

	/*
	 * To get tweet posted by current user
	 * 
	 * @param userId User Id of the current logged in user
	 * 
	 * @return List of tweet by current user
	 */
	public List<Post> getAllTweetByUser(int userId);

	/*
	 * To post Tweet posted by user
	 * 
	 * @param post details of post
	 */
	public void addTweet(Post post);

}
