// Menu of options that a student has when navigating the system

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GroupMenu extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating a heading
		Label header = new Label("Group Management Menu");
		
		// button to logout
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
	    	InstructorMenu instructorMenu = new InstructorMenu();
	    	instructorMenu.start(primaryStage);
	    });
		
		// button to search for articles
		Button groupSearchButton = new Button("Group Search");
        groupSearchButton.setOnAction(e -> {
            // Navigate to a new results screen (not implemented yet)
            GroupSearch grpSearch = new GroupSearch();
            grpSearch.start(primaryStage);
        });
		
		// button to get help with system (generic message)
		Button bckUpRestoreButton = new Button("BackUp/Restore Groups");
		bckUpRestoreButton.setOnAction(e -> {
			BackUpRestoreGroups srchScrn = new BackUpRestoreGroups();
			srchScrn.start(primaryStage);
        });
		
		// button to create groups send to groupCreate
		Button createGroupButton = new Button("Create group");
		createGroupButton.setOnAction(e -> {
			GroupCreate createGroup = new GroupCreate();
			createGroup.start(primaryStage);
        });
		
		// button to view groups
		Button viewGroupButton = new Button("View group");
		viewGroupButton.setOnAction(e -> {
			GroupView viewGroup = new GroupView();
			viewGroup.start(primaryStage);
        });
		
		//button to delete groups
		Button deleteGroupButton = new Button("Delete group");
		deleteGroupButton.setOnAction(e -> {
			GroupDelete deleteGroup = new GroupDelete();
	    	deleteGroup.start(primaryStage);
        });

		//button to edit groups
		Button editGroupButton = new Button("Edit group");
		editGroupButton.setOnAction(e -> {
			GroupEdit editGroup = new GroupEdit();
			editGroup.start(primaryStage);
        });


		// creating VBox to hold buttons on top of each other
		VBox vbox = new VBox(15); // 15 px spacing
        vbox.getChildren().addAll(header, groupSearchButton, bckUpRestoreButton, createGroupButton, 
        		viewGroupButton, deleteGroupButton, editGroupButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Group Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	//main
	public static void main(String[] args) 
	{
        launch(args);
    }
}
