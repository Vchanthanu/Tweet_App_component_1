package com.tweetapp.tweetservice.model;

/**
 * @author Chanthanu
 *
 */
public class User {
	private int id;
	private String firstName;
	private String gender;
	private String email;
	private String password;
	private boolean loginInd;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String gender, String email, String password, boolean loginInd) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.loginInd = loginInd;
	}

	public User(String firstName, String gender, String email, String password, boolean loginInd) {
		super();
		this.firstName = firstName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.loginInd = loginInd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoginInd() {
		return loginInd;
	}

	public void setLoginInd(boolean loginInd) {
		this.loginInd = loginInd;
	}

	@Override
	public String toString() {
		return "FirstName : " + firstName + "\tGender : " + gender + "\tEmail : " + email;
	}

}
