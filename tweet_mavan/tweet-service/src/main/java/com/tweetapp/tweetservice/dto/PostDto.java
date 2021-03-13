package com.tweetapp.tweetservice.dto;

public class PostDto {

	private String tweet;
	private String userName;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(String tweet, String userName) {
		super();
		this.tweet = tweet;
		this.userName = userName;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return userName + " : " + tweet;
	}

}
