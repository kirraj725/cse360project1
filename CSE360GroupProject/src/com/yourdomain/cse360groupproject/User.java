package com.yourdomain.cse360groupproject;

public class User {
	//attributes
	String firstName;
	String preferredName;
	String middleName;
	String lastName;
	String emailAddress;
	String username;
	int password;
	boolean isNewUser;
	boolean forgotPassword;
	boolean tempPassword;
	
	//default constructor
	public User() {
		firstName = "";
		preferredName = "";
		middleName = "";
		emailAddress = "";
		username = "";
		password = 0;
	}
	
	//overload constructor
	public User(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, int password) {
		this.firstName = firstName;
		this.preferredName = preferredName;
		this.middleName = middleName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}
	
	
}