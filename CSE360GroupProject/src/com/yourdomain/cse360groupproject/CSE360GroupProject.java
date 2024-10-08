package com.yourdomain.cse360groupproject;
public class CSE360GroupProject {
	public static void main(String[] args)
    {
		//testing 
		
		User newUser = new User("jane", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
		System.out.println(newUser.getFirstName());
		System.out.println(newUser.getLastName());
		System.out.println(newUser.getEmailAddress());
		System.out.println(newUser.getPassword());
		
    }
    
}