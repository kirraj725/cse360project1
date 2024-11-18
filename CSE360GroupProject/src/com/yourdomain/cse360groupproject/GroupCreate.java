// this is the class where a user can delete a new article

package com.yourdomain.cse360groupproject;

import java.util.jar.Attributes.Name;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GroupCreate extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("Create a Group");
		
		// group label and field for input
        Label groupLabel = new Label("Enter Group Name:");
        TextField groupField = new TextField("Enter group name...");
        Label addLabel = new Label("Enter Students/Instructors/Admin:");
        TextField addField = new TextField("Enter names to add...");

        
        // create group button
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> createGroup(groupField, addField));

        // back button send back to group menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            GroupMenu menu = new GroupMenu();
            menu.start(primaryStage);
        });

        // Creating a vbox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, groupLabel, groupField, addLabel, addField, 
        		createButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Create Group");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	//create group in database and send alert
	private void createGroup(TextField groupField, TextField addField) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Group created successfully!");
        alert.showAndWait();
    }

}
	