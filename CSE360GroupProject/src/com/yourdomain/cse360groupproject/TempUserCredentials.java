//Class used to Describe a temporary user
package com.yourdomain.cse360groupproject;
import java.time.LocalDateTime;
import java.util.Random;

public class TempUserCredentials {
	private int oneTimePassword;
	private LocalDateTime expiryDateTime;
	
	//default constructor
	public TempUserCredentials() {
		this.oneTimePassword = createOneTimePassword();
		this.expiryDateTime = LocalDateTime.now().plusDays(1);
	}
	
	//one time password getter
	public int getOneTimePassword() {
		return oneTimePassword;
	}
	
	//creates one time password
	public int createOneTimePassword() {
		Random random = new Random();
		String passwordString = "";
		
		//generates 10 integers from 0 to 9 and combines then into a string to create temporary password
		for(int i = 0; i < 10; i++) {
			int num = random.nextInt(10);
			String numStr = Integer.toString(num);
			passwordString += numStr;
		}
		oneTimePassword = Integer.parseInt(passwordString);	
		return oneTimePassword;
	}
	
	//date and time getter
	public LocalDateTime getDateTime() {
		return expiryDateTime;
	}
	
	//date and time setter
	public void setDateTime() {
		expiryDateTime = LocalDateTime.now().plusDays(1);
	}
	
	//checks if password is expired
	public boolean isPasswordExpired() {
		return LocalDateTime.now().isAfter(expiryDateTime);
	}	
}
