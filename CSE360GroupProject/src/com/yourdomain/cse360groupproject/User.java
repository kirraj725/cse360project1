package com.yourdomain.cse360groupproject;
import java.time.LocalDateTime;

public class User {
	//attributes
	private String firstName;
	private String preferredName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String username;
	private int password;
	private boolean isNewUser;
	private boolean forgotPassword;
	private TempUserCredentials tempCredentials;
	
	//default constructor
	public User() {
		firstName = "";
		preferredName = "";
		middleName = "";
		lastName = "";
		emailAddress = "";
		username = "";
		password = 0;
		isNewUser = true;
		forgotPassword = false;
	}
	
	//overload constructor
	public User(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, int password) {
		this.firstName = firstName;
		this.preferredName = preferredName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		isNewUser = true;
		forgotPassword = false;
	}
	
	//first name getter
	public String getFirstName() {
		return firstName;
	}
	
	//first name setter
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	//preferred name getter
	public String getPreferredName() {
		return preferredName;
	}
	
	//preferred name setter
	public void setPreferredName(String newPreferredName) {
		preferredName = newPreferredName;
	}
	
	//middle name getter
	public String getMiddleName() {
		return middleName;
	}
		
	//middle name setter
	public void setMiddleName(String newMiddleName) {
		middleName = newMiddleName;
	}
	
	//last name getter
	public String getLastName() {
		return lastName;
	}
			
	//last name setter
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	//email address getter
	public String getEmailAddress() {
		return emailAddress;
	}
				
	//email address setter
	public void setEmailAddress(String newEmailAddress) {
		emailAddress = newEmailAddress;
	}
	
	//username getter
	public String getUsername() {
		return username;
	}
					
	//username setter
	public void setUsername(String newUsername) {
		username = newUsername;
	}
	
	//password getter
	public int getPassword() {
		return password;
	}
						
	//password setter
	public void setPassword(int newPassword) {
		password = newPassword;
	}
	
}

