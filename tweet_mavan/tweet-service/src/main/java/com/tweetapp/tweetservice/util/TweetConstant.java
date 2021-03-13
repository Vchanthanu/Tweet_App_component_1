package com.tweetapp.tweetservice.util;

/**
 * @author Chanthanu
 *
 */
public class TweetConstant {

	public static final String ALL_USER = "SELECT * FROM tw_user";
	public static final String USER_BY_EMAIL = "SELECT id,first_name,gender,email,password,login_ind FROM tw_user WHERE tw_user.email = ?";
	public static final String USER_BY_LOG_IND = "SELECT id,first_name,gender,email,password,login_ind FROM tw_user WHERE tw_user.login_ind = ?";
	public static final String REGISTER_USER = "INSERT INTO tw_user (first_name,gender,email,password,login_ind) VALUES (?,?,?,?,?)";
	public static final String UPDATE_LOGIN_IND = "UPDATE tw_user SET login_ind = ? WHERE id = ?";
	public static final String UPDATE_PASSWORD = "UPDATE tw_user SET password = ? WHERE id = ?";

	public static final String ADD_TWEET = "INSERT INTO tw_post (tweet,tw_user_id) VALUES (?,?)";
	public static final String ALL_TWEET = "SELECT tweet.tw_user.first_name,tweet.tw_post.tweet FROM tweet.tw_post inner join tweet.tw_user  on ( tweet.tw_user.id = tweet.tw_post.tw_user_id)";
	public static final String GET_TWEET_BY_USERID = "SELECT * FROM tw_post where tw_user_id= ? ";
}
