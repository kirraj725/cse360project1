package com.yourdomain.cse360groupproject;

import java.util.List;
import java.util.ArrayList;


public class Administrator extends User{
	
	//create arraylist to store users in
	private List <User> userlist = new ArrayList();
	
	
	public void inviteUser(User user) {
		//generate one time code for new user
		
		User newUser = user;
		
		
		
		System.out.print("Select the roles for the new user: ");
		//set user input equal to roleInput string
		//string roleInput = 
		/*switch(roleInput) {
		//need to add button control stuff here
			case "Student":
				
			case "Instructor":
				
			case "Administrator":
		
		}*/
		
		userlist.add(newUser);
		
	}
	
	public void resetUserPassword(User user) {
		//
		
	}
	
	public void deleteUserAccount(User user) {
		
		
		System.out.println("Are you sure?");
		//add in button control here for Yes and No options
		
		
	}
	
	public void listUserAccounts() {
		
	}
	
	public void addUserRole() {
		
	}
	
	public void deleteUserRole() {
		
	}
	
	public void logout() {
		
	}
	
}
