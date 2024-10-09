package com.yourdomain.cse360groupproject;
public class CSE360GroupProject {
	
	public static final Database database = new Database();
	
	public static void main(String[] args)
    {
		
		try {
			database.connectToDatabase();
			
			if (database.isDatabaseEmpty()) {
				System.out.println( "In-Memory Database  is empty" );
				//set up administrator access
				VeryFirstLoginPage veryFirstPage = new VeryFirstLoginPage();
			}
			else {
				OriginalLoginScreen originalScreen = new OriginalLoginScreen();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		//testing 
		
		User newUser = new User("jane", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
		System.out.println(newUser.getFirstName());
		System.out.println(newUser.getLastName());
		System.out.println(newUser.getEmailAddress());
		System.out.println(newUser.getPassword());
		
    }
    
}