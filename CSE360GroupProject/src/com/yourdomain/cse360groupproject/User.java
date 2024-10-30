//Class to describe a user
package com.yourdomain.cse360groupproject;

public class User {
	//attributes
	private String firstName;
	private String preferredName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String username;
	private String password;
	private String role;
	private boolean isNewUser;
	private boolean isTempPassword;
	private TempUserCredentials tempCredentials;
	
	
	//default constructor
	public User() {
		firstName = "";
		preferredName = "";
		middleName = "";
		lastName = "";
		emailAddress = "";
		username = "";
		password = "";
		role = "";
		isNewUser = true;
		isTempPassword = true;
		tempCredentials = new TempUserCredentials();
	}
	
	//overload constructor
	public User(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, String password, String role) {
		this.firstName = firstName;
		this.preferredName = preferredName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.role = role;
		isNewUser = true;
		isTempPassword = true;
		tempCredentials = new TempUserCredentials();
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
	public String getPassword() {
		return password;
	}
						
	//password setter
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	//role getter
	public String getRole() {
		return role;
	}
						
	//role setter
	public void setRole(String newRole) {
		role = newRole;
	}
	
	public String[] getFormattedString() {
		String[] fs = new String[] {firstName, middleName, lastName, preferredName, emailAddress, username, password, role};
		
		return fs;
	}
	
	//dump for debug
	public void dump() {
		System.out.println("DUMP...");
		System.out.println("first name: " + firstName + " | middle name: " + middleName + " | last name: " + lastName + " | preferred name: " + preferredName +
				" | email address: " + emailAddress + " | username: " + username + " | password: " + password + " | role: " + role);
	}
	
	
}

