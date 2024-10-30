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
	//private User user;
	
	public void start(Stage primaryStage)
	{
		// Debug statement to print the current working directory
	    System.out.println("Current working directory: " + System.getProperty("user.dir"));
		//Using csv file handler to decide if this is the very first user or a regular user
		CSVfileHandler csvfileHandler = new CSVfileHandler("src/resources/csv_empty.csv");
		if (csvfileHandler.isCSVFileEmpty("src/resources/csv_empty.csv")) {
			//print out file is empty if it is empty
			System.out.println( "File is empty" );
			
			//set up administrator access
			VFirstLgnPg veryFirstPage = new VFirstLgnPg();
			veryFirstPage.start(primaryStage);
	        
		}
		else {
			OrigLgnScrn originalScreen = new OrigLgnScrn();
			originalScreen.start(primaryStage);

		}
	}

	//Launching the driver method
	public static void main(String[] args)
	{
		launch(args);
	}
    
}
