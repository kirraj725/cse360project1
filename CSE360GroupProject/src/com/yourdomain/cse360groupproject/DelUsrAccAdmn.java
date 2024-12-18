//This is where the admin can delete a User's account
package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class DelUsrAccAdmn extends Application {
   public void start(Stage primaryStage) {
	   //Creating the delete account label and button
      Label delAccLabel = new Label("Would you like to delete this account?");
      Button delAccButton = new Button("Yes, delete this account");
      delAccButton.setOnAction(e -> {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Account Deletion");
    		alert.setHeaderText(null);
    		alert.setContentText("The account has been deleted.");
    		alert.showAndWait();
      // delete acc from database
      });
      Button backButton = new Button("Back");
      // add action of back button to take back to acc list
      backButton.setOnAction(e -> {
    	  	AccountList AccList = new AccountList();
      		AccList.start(primaryStage);	  
      });
      
      //Used to hold everything together
      VBox vbox = new VBox(20);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(delAccLabel, delAccButton, backButton);
      Scene scene = new Scene(vbox, 300, 200);
      primaryStage.setTitle("Account Deletion Page");
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }
   
 //  public static void main(String[] args)
	// {
		//launch(args);
//	}
	
}

