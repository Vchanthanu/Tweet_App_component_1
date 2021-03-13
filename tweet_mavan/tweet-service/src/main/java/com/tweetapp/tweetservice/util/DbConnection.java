package com.tweetapp.tweetservice.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {

	public static Connection getDbConnection() {
		Connection connection = null;
		try {
//			InputStream inputStream = DbConnection.class
//					.getResourceAsStream("src/main/java/db.properties");
//			System.out.print(properties);
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/java/com/tweetapp/tweetservice/util/db.properties"));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("connection-url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Input Output exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Class file not found Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Sql Exception");
		}
		return connection;
	}

}
