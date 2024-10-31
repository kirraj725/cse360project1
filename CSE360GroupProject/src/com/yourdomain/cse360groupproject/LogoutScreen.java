//This is a screen that allows a user to logout
package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogoutScreen extends Application {
	private User user;
	
   public void start(Stage primaryStage) {
      //Creating logout label & button
      Label logoutLabel = new Label("Would you like to logout of this account?");
      Button logoutButton = new Button("Yes, logout of this account");
      logoutButton.setOnAction((e) -> {
         OrigLgnScrn oriLogin = new OrigLgnScrn();
         oriLogin.start(primaryStage);
      });
      //Creating Back button
      Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
    	  	AccountList AccList = new AccountList();
      		AccList.start(primaryStage);	  
      });
      //VBox is used to hold everything together
      VBox vbox = new VBox(20);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(logoutLabel, logoutButton, backButton);
      //showing stage & setting scene
      Scene scene = new Scene(vbox, 300, 200);
      primaryStage.setTitle("Logout Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
