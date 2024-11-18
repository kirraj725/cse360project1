// Menu of options that a student has when navigating the system

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchBasic extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating a heading
		Label header = new Label("Search Menu");
		
		// button to go back to instructor menu
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
	    	InstructorMenu instructorMenu = new InstructorMenu();
	    	instructorMenu.start(primaryStage);
	    });
		
		// button to search for articles
		Button searchButton = new Button("Search Articles");
		searchButton.setOnAction(e -> {
			SearchScreenInstr srchScrn = new SearchScreenInstr();
			srchScrn.start(primaryStage);
        });
		
		// button to get help with system (generic message)
		Button systemHelpButton = new Button("System Help");
		systemHelpButton.setOnAction(e -> {
			SysHelpInstr systemHelp = new SysHelpInstr();
			systemHelp.start(primaryStage);
        });
		
		// button to give suggestions (specific message)
		Button suggestionButton = new Button("Leave a Suggestion");
		suggestionButton.setOnAction(e -> {
			SuggScreenInstr suggScrn = new SuggScreenInstr();
	    	suggScrn.start(primaryStage);
        });

		// creating VBox to hold buttons on top of each other
		VBox vbox = new VBox(15); // 15 px spacing
        vbox.getChildren().addAll(header, searchButton, systemHelpButton, suggestionButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Search Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
