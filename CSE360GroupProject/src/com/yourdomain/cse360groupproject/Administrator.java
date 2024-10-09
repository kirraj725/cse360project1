package com.yourdomain.cse360groupproject;

import java.util.List;
import java.util.ArrayList;
import java.security.SecureRandom;


public class Administrator extends User{
	public String roleInput = "";	//
	//create arraylist to store users in
	public List<User> userlist = new ArrayList<User>();
	public List<String> roles = new ArrayList<String>();
	
	
	//constructor
    public Administrator(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, int password, String role) {
        super(firstName, preferredName, middleName, lastName, emailAddress, username, password, role);
        //roleInput = "Administrator";
        this.userlist = new ArrayList<>();
    }
    public Administrator() {
    	super();
    	this.userlist = new ArrayList<>();
    	
    }
	
	public String inviteUser(User user) {
		
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
		
		//generate the invitation code
		int codeLength = 6;
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder userCode = new StringBuilder(codeLength);

        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(characters.length());
            userCode.append(characters.charAt(index));
        }
        String generatedCode = userCode.toString();

        System.out.print(generatedCode);
        
        
        //compare code we generated versus
		
	}
	
	
	public void resetUserPassword(User user) {
		
		
		//generate one-time code
		int codeLength = 6;
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder userCode = new StringBuilder(codeLength);

        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(characters.length());
            userCode.append(characters.charAt(index));
        }

        return userCode.toString();	
		
		
	}
	
	public void deleteUserAccount(User user, String roleInput) {
		
		
		System.out.println("Are you sure?");
		
		if(roleInput == "Yes") {
			userlist.remove(user);
			System.out.print("User deleted");
			
		}else {
			System.out.print("User not deleted");
			
		}
		//add in button control here for Yes and No options?
		
			
	}
	
	public void listUserAccounts(List<User>userlist) {
		//System.out.print(userlist);
		for (User user : userlist) {
            System.out.println("Name: " + user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email Address: " + user.getEmailAddress());
            
            // Display roles if they are defined as separate classes or stored in a list in User
            if (user.getRole() == "Student") {
                System.out.println("Role: Student");
            }
            if (user.getRole() == "Instructor") {
                System.out.println("Role: Instructor");
            }
            if (user.getRole() == "Administrator") {
                System.out.println("Role: Administrator");
            }
            System.out.println("-------------------------");
        }
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