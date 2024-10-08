package com.yourdomain.cse360groupproject;

import java.util.List;
import java.util.ArrayList;


public class Administrator extends User{
	public String roleInput = "";	//
	//create arraylist to store users in
	public List <User> userlist = new ArrayList<>();
	
	
	//constructor
    public Administrator(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, int password) {
        super(firstName, preferredName, middleName, lastName, emailAddress, username, password);
        roleInput = "Administrator";
    }
	
	public void inviteUser(User user) {
		//generate one time code for new user
		
		User newUser = user;
		
		
		
		System.out.print("Select the roles for the new user: ");
		//set user input equal to roleInput string
		//string roleInput = "";
		/*switch(roleInput) {
		need to add button control stuff here
			case "Student":
				roleInput = "Student";
				newUser.setRole(roleInput);
				
			case "Instructor":
				roleInput = "Instructor";
				newUser.setRole(roleInput);
				
			case "Administrator":
				roleInput = "Administrator";
				newUser.setRole(roleInput);
		
		}*/
		
		userlist.add(newUser);
		
	}
	
	
	public void resetUserPassword(User user) {
		
		
	}
	
	public void deleteUserAccount(User user, String roleInput) {
		
		
		System.out.println("Are you sure?");
		
		if(roleInput == "Yes") {
			
		}
		//add in button control here for Yes and No options
		
		
		
	}
	
	public void listUserAccounts(List userlist) {
		//System.out.print(userlist);
		//for(User user : userlist) {
			
		//}
		
		
	}
	
	public void addUserRole(String roleInput) {
		switch(roleInput) {
			case("Student"):
				
		}
		
		
	}
	
	public void deleteUserRole(String roleInput, String email) {
		switch(roleInput) {
			case("Student"):
			
				
			case("Instuctor"):
			
			case("Administrator"):
			
		}
				
		
	}
	
	public void logout() {
		
		
	}
	
}
