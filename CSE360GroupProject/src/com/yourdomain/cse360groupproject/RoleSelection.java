// This is the screen where the user can select their role
package com.yourdomain.cse360groupproject;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoleSelection extends Application
{
	// Variables for constructor
	private String preferredName;
	private String role = "";
	private CSVfileHandler csvhandler = new CSVfileHandler("src/resources/csv_empty.csv");
	private User user;
	//private User user;
		
	// Constructor to pass the preferred name and first name
	public RoleSelection(User pUser)
	{
		user = pUser;
		this.preferredName = user.getPreferredName();
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the heading
		Label headingLabel = new Label("Welcome " + preferredName + "! Please select role!");
		
		// Buttons for Role Selection
		//Admin button
		Button adminButton = new Button("Admin");
		adminButton.setOnAction(e -> {
        	role = "Admin";		//once button is pressed assign role to admin
        	System.out.println(role);		//debug
        	user.setRole(role);		        	//set user role to role
            handleWriteToCSV(user);		        	// Call handleWriteToCSV with the User instance
            AccountList AccList = new AccountList();
        	AccList.start(primaryStage);

		});
		
		//Instructor button
        Button instructorButton = new Button("Instructor");
        instructorButton.setOnAction(e -> {
        	role = "Instructor"; 	//once button is pressed assign role to instructor
        	System.out.println(role);	//debug
        	user.setRole(role);		//set user role to role
        	// Call handleWriteToCSV with the User instance
            handleWriteToCSV(user);
            ArticleMenuManagement artMenuMan = new ArticleMenuManagement();
        	artMenuMan.start(primaryStage);
        });
        
        //Student button
        Button studentButton = new Button("Student");
        studentButton.setOnAction(e -> {
        	role = "Student";		//once button is pressed assign role to student
        	System.out.println(role); 	//debug
        	user.setRole(role);		//set user role to role
          	// Call handleWriteToCSV with the User instance
            handleWriteToCSV(user);
            LogoutScreen logOutPage = new LogoutScreen();
        	logOutPage.start(primaryStage);
        });
        
        // Creating VBox to hold buttons on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(headingLabel, adminButton, instructorButton, studentButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Role Selection Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
	}
	
	public void handleWriteToCSV(User user)
	{
		//create an instance of csvfilehandler
		CSVfileHandler csvhandler = new CSVfileHandler("src/resources/csv_empty.csv");
				
	    String[] userData = user.getFormattedString();
	    System.out.println("write string: " + userData);
	    
	    //New array list dataToWrite grab userData
		List<String[]> dataToWrite = new ArrayList<>();
		dataToWrite.add(userData);
		
		//dump contents
		System.out.println("RoleSelection dumping...");
		user.dump();
		
		//send dataToWrite data to WriteToCSV
		csvhandler.writeToCSV(dataToWrite);
	}
}

