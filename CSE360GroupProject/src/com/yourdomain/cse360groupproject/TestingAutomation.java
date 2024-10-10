package TEST1Phase1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

//class for automated testing 
public class TestingAutomation {
	
	//keeps track of number of failed and passed test cases
	static int numPassed = 0;
	static int numFailed = 0;
	
	public static void main(String[] args) {
		
		//creating two user objects for testing
		UserTest1 User1 = new UserTest1("jane", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
		UserTest1 User2 = new UserTest1("Alexandra", "Alex", "", "Smith", "asmith3@asu.edu", "asmith34", 4567, "admin");
		
		
		//setting first name of user1 to Jordan and running automation test on the user object
		User1.setFirstName("Jordan");
		userTestCase(1, User1, false, "Jordan", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
	
		//setting email of user2 to asmith367@asu.edu and the password to 9874 and running automation test on the user object
		User2.setEmailAddress("asmith367@asu.edu");
		User2.setPassword(9874);
		userTestCase(2, User2, true, "Alexandra", "Alex", "", "Smith", "asmith367@asu.edu", "asmith34", 9874, "admin");
		
		//creating a temp credentials object for testing
		TempUserCredentialsTest1 tempCred = new TempUserCredentialsTest1();
		//changing the date and running the automated test case function
		tempCred.setDateTime();
		tempCredTestCase (3, tempCred.isPasswordExpired(), true);
		
		AdministratorTest1 testadmin = new AdministratorTest1("Daniel", "Garfield", "", "Gomez", "dgomez3@asu.edu", "dgomex23", 7390, "admin");	//creating admin object
		List<UserTest1> userlist = new ArrayList<UserTest1>();	//create test userlist
		userlist.add(User2);		//add user2 to test userlist
		resetPasswordTest(testadmin, User2, false);		//call and test resetpassword function
		listUserAccountsTest(testadmin, userlist, true);		//call and test listing the user accounts function from administrator class
		
		testadmin.userlist.add(User2);		//add user2 to userlist
        testadmin.deleteUserAccount(User2, "Yes"); // delete User2 from userlist
		
		
		//printing the number of passed and failed test cases
		System.out.println("Number of tests passed: " + numPassed);
		System.out.println("Number of tests failed: " + numFailed);
	}
	
	//tests user object
	private static void userTestCase (int testCase, UserTest1 user, boolean expectedPass, String expectedFirstName, String expectedPreferredName, String expectedMiddleName, String expectedLastName, String expectedEmail, String expectedUsername, int expectedPassword, String expectedRole) {
		boolean pass = true; //
	
		//checks if first name of user object are not equal to expected value
		if (user.getFirstName() != expectedFirstName)  {
			pass = false; 
		//checks if preferred name of user object are not equal to expected value
		} else if (user.getPreferredName() != expectedPreferredName) {
			pass = false;
		//checks if middle name of user object are not equal to expected value
		} else if (user.getMiddleName() != expectedMiddleName) {
			pass = false;
		//checks if last name of user object are not equal to expected value
		} else if (user.getLastName() != expectedLastName) {
			pass = false;
		//checks if email of user object are not equal to expected value
		} else if (user.getEmailAddress() != expectedEmail) {
			pass = false;
		//checks if username of user object are not equal to expected value
		} else if (user.getUsername() != expectedUsername) {
			pass = false;
		//checks if password of user object are not equal to expected value
		} else if (user.getPassword() != expectedPassword) {
			pass = false;
		//checks if role of user object are not equal to expected value
		} else if (user.getRole() != expectedRole) {
			pass = false;
		} 
		
		//prints success message and increases success counter if expected pass is same as pass
		if (expectedPass == pass) {
			System.out.println("user test case is a success!");
			numPassed++;
		//prints fail message and increases fail counter if expected pass is same as pass
		} else {
			System.out.println("user test case is a fail.");
			numFailed++;
		}
	}
	
	//tests temp credentials object
	private static void tempCredTestCase (int testCase, boolean isExpired, boolean expectedPass) {
		
		//checks if expected pass and expire boolean are equivalent, and prints success message 
		if (expectedPass == isExpired) {
			System.out.println("user test case is a success!");
			numPassed++;
		} else {
			//prints fail message if expected pass and expire boolean are not equal
			System.out.println("user test case is a fail.");
			numFailed++;
		}
	}
	
	//tests listing out user accounts for admin object
	private static void listUserAccountsTest(AdministratorTest1 testadmin, List<UserTest1> userlist, boolean expected) {	//test function for listing elements
	    System.out.println("List User Accounts");
	    testadmin.listUserAccounts(testadmin.userlist);		//call function to list user accounts for the admin
	    
	    boolean pass = testadmin.userlist.equals(userlist);  		//set boolean equal to if the userlists are equal
	    
	    if (pass == expected) {	
	        System.out.println("User list is correct.");	//list is correct as expected
	        numPassed++;		//add one to number of cases passed
	    } else {
	        System.out.println("User list is incorrect.");	//list is incorrect
	        numFailed++;		//add one to number of cases failed
	    }
	}
	
	//tests reset password for admin object
	private static void resetPasswordTest(AdministratorTest1 testadmin, UserTest1 User2, boolean expected) {	//method to test reset password method in admin class
	    testadmin.resetUserPassword(User2);  // run reset user password method
	    
	    System.out.println("Reset Password");		
	    if (expected) {		//if the password is reset
	        System.out.println("Password reset successful.");		//print statement for passed password reset
	        numPassed++;		//add one to number of cases passed
	    } else {
	        System.out.println("Password reset failed.");		//print statement for failed password reset
	        numFailed++;		//add one to number of cases failed
	    }
	}
	
	
	
}
