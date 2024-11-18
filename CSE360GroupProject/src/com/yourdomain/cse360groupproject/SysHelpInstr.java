// this is the screen where students can get help with tools of the system

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SysHelpInstr extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating the heading
		Label header = new Label("System Help");
		
		// button for searching help
		Button searchButton = new Button("Searching Help");
        searchButton.setOnAction(e -> showHelpAlert("Searching Help", "This explains how to search for articles in the system."));
        
        // creating more buttons
        Button specificMessageButton = new Button("Specific Message Help");
        specificMessageButton.setOnAction(e -> showHelpAlert("Specific Message Help", "This explains how to submit a specific message with a suggestion."));
        
        // back button to go back to Student Menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
        	SearchBasic instrMenu = new SearchBasic();
        	instrMenu.start(primaryStage);
        });
        
        // create a vbox to put everything on top of each other
        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(header, searchButton, specificMessageButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setTitle("System Help");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	// alerts for help buttons
	private void showHelpAlert(String title, String message) 
	{
        Alert helpAlert = new Alert(AlertType.INFORMATION);
        helpAlert.setTitle(title);
        helpAlert.setHeaderText(null);
        helpAlert.setContentText(message);
        helpAlert.showAndWait();
    }
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
