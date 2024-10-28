//This is the screen where the admin sends an email to invite a new user
package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AccountInvite extends Application {		//GUI class for sending an invitation to a user
   public void start(Stage primaryStage) {
	   Label pickRoleLabel = new Label("Pick a temporary role for invitation:");	//label on GUI to ask admin to pick role for user 
	      Button AdminButton = new Button("Admin");				//admin button
	      Button instructorButton = new Button("Instructor");		//Instructor button
	      Button StudentButton = new Button("Student");			//student button
	      Label EmailLabel = new Label("Email:");				//label to ask for email
	      TextField emailField = new TextField();				//textfield for user to enter email
	      Button SendButton = new Button("Send");				//button to send information
	      Button backButton = new Button("Back");				//back button to go back to previous page
	      backButton.setOnAction(e -> {
              AccountList AccList = new AccountList();
		      AccList.start(primaryStage);                              
	      });
	      HBox emailBox = new HBox(10);					//horizontal box for email
	      emailBox.setAlignment(Pos.CENTER);				//aligning the email box to center of pane
	      emailBox.getChildren().addAll(EmailLabel, emailField);		//adding the email lab and email textfield to the email box
	      HBox buttonBox = new HBox(10);					//new hbox for buttons
	      buttonBox.setAlignment(Pos.CENTER);				//centering button box to center of pane
	      buttonBox.getChildren().addAll(AdminButton, instructorButton, StudentButton);		//inserting the buttons for three user roles 
	      VBox vbox = new VBox(20);						//new vertical box for adding in elements 
	      vbox.setAlignment(Pos.CENTER);				//center aligning the vertical box
	      vbox.getChildren().addAll(pickRoleLabel, buttonBox,emailBox, SendButton, backButton);		//add labelds, boxes, and buttons
	      Scene scene = new Scene(vbox, 400, 400);				//set the scene
	      primaryStage.setTitle("Admin Invitation Page");			//set title for stage
	      primaryStage.setScene(scene);					//setting the scence
	      primaryStage.show();						//showing the primary stage with all the components
   
	      
   }
   
   public static void main(String[] args)
   {
	   launch(args);
   }
}
