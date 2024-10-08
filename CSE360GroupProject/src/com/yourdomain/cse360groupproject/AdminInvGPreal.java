package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class AdminInvGPreal extends Application {
   public void start(Stage primaryStage) {
	   Label pickRoleLabel = new Label("Pick a temporary role for invitation:");
	      Button AdminButton = new Button("Admin");
	      Button instructorButton = new Button("Instructor");
	      Button StudentButton = new Button("Student");
	      Label EmailLabel = new Label("Email:");
	      TextField emailField = new TextField();
	      Button SendButton = new Button("Send");
	      Button backButton = new Button("Back");
	      //add action
	      HBox emailBox = new HBox(10);
	      emailBox.setAlignment(Pos.CENTER);
	      emailBox.getChildren().addAll(EmailLabel, emailField);
	      HBox buttonBox = new HBox(10);
	      buttonBox.setAlignment(Pos.CENTER);
	      buttonBox.getChildren().addAll(AdminButton, instructorButton, StudentButton);
	      VBox vbox = new VBox(20);
	      vbox.setAlignment(Pos.CENTER);
	      vbox.getChildren().addAll(pickRoleLabel, buttonBox,emailBox, SendButton, backButton);
	      
   
	      
   }
}
