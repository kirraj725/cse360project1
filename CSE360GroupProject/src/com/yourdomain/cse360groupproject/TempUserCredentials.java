package com.yourdomain.cse360groupproject;
import java.time.LocalDateTime;
import java.util.Random;

public class TempUserCredentials {
	private int oneTimePassword;
	private LocalDateTime expiryDateTime;
	
	//overload constructor
	public TempUserCredentials(int oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
		this.expiryDateTime = LocalDateTime.now().plusDays(1);
	}
	
	//one time password getter
	public int getOneTimePassword() {
		return oneTimePassword;
	}
	
	//creates one time password
	public void createOneTimePassword() {
		Random rand = new Random();
		oneTimePassword = rand.nextInt(1000000000);
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