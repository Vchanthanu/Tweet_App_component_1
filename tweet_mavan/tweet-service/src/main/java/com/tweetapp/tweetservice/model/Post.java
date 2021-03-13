package com.tweetapp.tweetservice.model;

/**
 * @author Chanthanu
 *
 */
public class Post {

	private int id;
	private String tweet;
	private int userId;

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Post(int id, String tweet, int userId) {
		super();
		this.id = id;
		this.tweet = tweet;
		this.userId = userId;
	}

	public Post(String tweet, int userId) {
		super();
		this.tweet = tweet;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return  tweet;
	}

}
