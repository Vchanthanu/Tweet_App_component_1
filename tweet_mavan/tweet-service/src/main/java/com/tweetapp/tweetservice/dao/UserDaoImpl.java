package com.tweetapp.tweetservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.tweetservice.model.User;
import com.tweetapp.tweetservice.util.DbConnection;
import com.tweetapp.tweetservice.util.TweetConstant;

public class UserDaoImpl implements UserDao {

	Connection connection;
	private PreparedStatement preparedStatment;
	private ResultSet resultSet;

	@Override
	public List<User> getAllUser() {
		connection = DbConnection.getDbConnection();
		ArrayList<User> users = new ArrayList<>();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.ALL_USER);
			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				boolean loginInd = (resultSet.getString("login_ind").equals("Y"));
				User user = new User(id, firstName, gender, email, password, loginInd);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in getting All User details");
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection not closed properly");
			}
		}
		return users;
	}

	@Override
	public void registerUser(User user) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.REGISTER_USER);
			preparedStatment.setString(1, user.getFirstName());
			preparedStatment.setString(2, user.getGender());
			preparedStatment.setString(3, user.getEmail());
			preparedStatment.setString(4, user.getPassword());
			preparedStatment.setString(5, "N");
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in registering User");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection is  not closed properly");
			}
		}
	}

	@Override
	public User userExist(String email_user) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.USER_BY_EMAIL);
			preparedStatment.setString(1, email_user);
			resultSet = preparedStatment.executeQuery();
			User user = null;
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				boolean loginInd = (resultSet.getString("login_ind").equals("Y"));
				user = new User(id, firstName, gender, email, password, loginInd);
				return user;
			} else {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in getting user by user email id");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection is  not closed properly");
			}
		}
	}

	@Override
	public void updateLogInd(String ind, int userId) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.UPDATE_LOGIN_IND);
			preparedStatment.setString(1, ind);
			preparedStatment.setInt(2, userId);
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in setting logde in status");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection is  not closed properly");
			}
		}
	}

	@Override
	public void updatePassword(int userId, String password) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.UPDATE_PASSWORD);
			preparedStatment.setString(1, password);
			preparedStatment.setInt(2, userId);
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in updating new password");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection is  not closed properly");
			}
		}
	}

	@Override
	public User getUserByInd(String ind) {
		connection = DbConnection.getDbConnection();
		try {
			preparedStatment = connection.prepareStatement(TweetConstant.USER_BY_LOG_IND);
			preparedStatment.setString(1, ind);
			resultSet = preparedStatment.executeQuery();
			User user = null;
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				boolean loginInd = (resultSet.getString("login_ind").equals("Y"));
				user = new User(id, firstName, gender, email, password, loginInd);
				return user;
			} else {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Touble in getting user by logged in indicator");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
