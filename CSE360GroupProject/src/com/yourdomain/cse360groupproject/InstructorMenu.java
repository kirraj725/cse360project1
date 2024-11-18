// Menu of options that a student has when navigating the system

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstructorMenu extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating a heading
		Label header = new Label("Instructor Menu");
		
		// button to logout
		Button logoutButton = new Button("Logout");
		logoutButton.setOnAction(e -> {
	    	LogoutScreen logoutScrn = new LogoutScreen();
	    	logoutScrn.start(primaryStage);
	    });
		
		// button to search for articles
		Button searchMenuButton = new Button("Search Menu");
		searchMenuButton.setOnAction(e -> {
			SearchBasic searchBasicScrn = new SearchBasic();
			searchBasicScrn.start(primaryStage);
        });
		
		// button to get help with system (generic message)
		Button articleMenuButton = new Button("Article Menu");
		articleMenuButton.setOnAction(e -> {
			ArticleMenuManagementInstr articleMnMgn = new ArticleMenuManagementInstr();
			articleMnMgn.start(primaryStage);
        });
		
		// button to give suggestions (specific message)
		Button groupMenuButton = new Button("Group Menu");
		groupMenuButton.setOnAction(e -> {
			GroupMenu groupMn = new GroupMenu();
	    	groupMn.start(primaryStage);
        });

		// creating VBox to hold buttons on top of each other
		VBox vbox = new VBox(15); // 15 px spacing
        vbox.getChildren().addAll(header, searchMenuButton, articleMenuButton, groupMenuButton, logoutButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Instructor Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
