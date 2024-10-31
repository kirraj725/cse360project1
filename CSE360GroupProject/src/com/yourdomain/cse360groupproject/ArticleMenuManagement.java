// This is the menu of options that admin and instructors have when managing articles

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ArticleMenuManagement extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the heading
		Label headingLabel = new Label("Article Menu");
		
		// Buttons for menu options
		Button createArtButton = new Button("Create Article");
		createArtButton.setOnAction(e -> {
			CreateArt createArtPage = new CreateArt();
			createArtPage.start(primaryStage);
		});
		
		Button updateArtButton = new Button("Update Article");
		updateArtButton.setOnAction(e -> {
			UpdateArt updateArtPage = new UpdateArt();
			updateArtPage.start(primaryStage);
        });
		
		Button viewArtButton = new Button("View Article");
		viewArtButton.setOnAction(e -> {
			ViewArt viewArtPage = new ViewArt();
			viewArtPage.start(primaryStage);
        });
		
		Button delArtButton = new Button("Delete Article");
		delArtButton.setOnAction(e -> {
			DeleteArt deleteArtPage = new DeleteArt();
			deleteArtPage.start(primaryStage);
        });
		
		Button listArtButton = new Button("List Articles");
		listArtButton.setOnAction(e -> {
        	//LOSTest1 logOutPage = new LOSTest1();
        	//logOutPage.start(primaryStage);
        });
		
		Button logoutButton = new Button("Yes, logout of this account");
	    logoutButton.setOnAction(e -> {
	    	LogoutScreen logoutScrn = new LogoutScreen();
	    	logoutScrn.start(primaryStage);
	    });
		
		// Creating VBox to hold buttons on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(headingLabel, createArtButton, updateArtButton, viewArtButton, delArtButton, listArtButton, logoutButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Article Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);

	
	}
}
