package com.tweetapp.tweetservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.tweetservice.dto.PostDto;
import com.tweetapp.tweetservice.model.Post;
import com.tweetapp.tweetservice.model.User;
import com.tweetapp.tweetservice.util.DbConnection;
import com.tweetapp.tweetservice.util.TweetConstant;

/**
 * @author Chanthanu
 *
 */
public class PostDaoImpl implements PostDao {

	Connection connection;
	private PreparedStatement preparedStatment;
	private ResultSet resultSet;

	@Override
	public List<PostDto> getAllTweet() {
		connection = DbConnection.getDbConnection();
		ArrayList<PostDto> tweets = new ArrayList<>();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.ALL_TWEET);
			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String desc = resultSet.getString("tweet");
				PostDto tweet = new PostDto(firstName, desc);
				tweets.add(tweet);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("Touble in getting All Tweet details");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
//				e.printStackTrace();
				throw new RuntimeException("Connection not closed properly");
			}
		}
		return tweets;
	}

	@Override
	public List<Post> getAllTweetByUser(int userId) {
		connection = DbConnection.getDbConnection();
		ArrayList<Post> tweets = new ArrayList<>();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.GET_TWEET_BY_USERID);
			preparedStatment.setInt(1, userId);
			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				String desc = resultSet.getString("tweet");
				int user = resultSet.getInt("tw_user_id");
				Post tweet = new Post(desc, user);
				tweets.add(tweet);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("Touble in getting Tweet by user");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
//				e.printStackTrace();
				throw new RuntimeException("Connection not closed properly");
			}
		}
		return tweets;
	}

	@Override
	public void addTweet(Post post) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.ADD_TWEET);
			preparedStatment.setString(1, post.getTweet());
			preparedStatment.setInt(2, post.getUserId());
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("Touble in posting Tweet");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
//				e.printStackTrace();
				throw new RuntimeException("Connection is  not closed properly");
			}
		}
	}

	public void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatment != null) {
			preparedStatment.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
