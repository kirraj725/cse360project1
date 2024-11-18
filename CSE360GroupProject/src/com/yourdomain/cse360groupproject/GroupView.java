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

public class GroupView extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("View Groups");

		// id label and field for input
        Label idLabel = new Label("Enter Group Name:");
        TextField idField = new TextField();
        
        //article details
        TextArea groupDetails = new TextArea();
        groupDetails.setEditable(false);
        
        // view button
        Button viewButton = new Button("View");
        viewButton.setOnAction(e -> viewGroup(idField, groupDetails));
        
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            GroupMenu menu = new GroupMenu();
            menu.start(primaryStage);
        });

        // Creating a vbox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, idLabel, idField, viewButton, groupDetails, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("View Groups");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	// Retrieve the group by name and display details
	private void viewGroup(TextField idField, TextArea articleDetails) 
	{
        String groupName = idField.getText();

        if (groupName.isEmpty()) 
        {
            articleDetails.setText("Please enter a group name.");
            return;
        }

        articleDetails.setText("Displaying details of group: " + groupName);
    }

}
	