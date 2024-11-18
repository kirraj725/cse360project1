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

public class GroupEdit extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("Edit a Group");
		
		// id label and field for input
        Label groupLabel = new Label("Enter Group Name:");
        TextField groupField = new TextField("Enter group name...");
        Label editLabel = new Label("Enter name to add/remove:");
        TextField editField = new TextField("Enter name...");

        
        // add button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addName(groupField));
        
        // remove button
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> removeName(groupField));
        
        
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            GroupMenu menu = new GroupMenu();
            menu.start(primaryStage);
        });

        // Creating a vbox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, groupLabel, groupField, editLabel, editField, 
        		addButton, removeButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Edit Group");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	//add a name into the group
	private void addName(TextField groupField) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Added successfully!");
        alert.showAndWait();
    }
	
	//remove a name in a group
	private void removeName(TextField groupField) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Removed successfully!");
        alert.showAndWait();
    }
	
}
	