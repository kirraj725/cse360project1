//main driver class
package com.yourdomain.cse360groupproject;

import java.util.ArrayList;
import java.util.List;

//import java.sql.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSE360GP extends Application {
	
//	public static final CSVfileHandler CSVfile = new CSVfileHandler("src/resources/data_csv.csv");
	
	public void start(Stage primaryStage)
	{
		// Debug statement to print the current working directory
	    System.out.println("Current working directory: " + System.getProperty("user.dir"));
		//Using csv file handler to decide if this is the very first user or a regular user
		CSVfileHandler csvfileHandler = new CSVfileHandler("src/resources/csv_empty.csv");
		//CSVfileHandler.writeToCSV(data);
		if (csvfileHandler.isCSVFileEmpty("src/resources/csv_empty.csv")) {
			//print out file is empty if it is empty
			System.out.println( "File is empty" );
			
			
			/*
			String username = "admin";
			String password = "password";
			String[] userData = new String[] {
					"", "", "", "", "", username, password, "admin"
			};
					    
			List<String[]> dataToWrite = new ArrayList<>();
			dataToWrite.add(userData);
			
		    csvfileHandler.writeToCSV(dataToWrite);
		    */
			
			//set up administrator access
			VFirstLgnPg veryFirstPage = new VFirstLgnPg();
			veryFirstPage.start(primaryStage);
	        
		}
		else {
			OrigLgnScrn originalScreen = new OrigLgnScrn();
			originalScreen.start(primaryStage);
		}
	}
	
	
		
		
		//testing 
		
//		UserTest1 newUser = new UserTest1("jane", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
//		System.out.println(newUser.getFirstName());
//		System.out.println(newUser.getLastName());
//		System.out.println(newUser.getEmailAddress());
//		System.out.println(newUser.getPassword());

	//Launching the driver method
	public static void main(String[] args)
	{
		launch(args);
	}
    
}
