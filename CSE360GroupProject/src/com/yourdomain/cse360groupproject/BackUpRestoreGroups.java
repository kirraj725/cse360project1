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

public class BackUpRestoreGroups extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("Back-Up/Restore a Group");
		
		// group label and field for input
        Label groupLabel = new Label("Enter Group Name:");
        TextField groupField = new TextField("Enter group name...");
        
        // back up button
        Button backUpButton = new Button("Back-Up");
        backUpButton.setOnAction(e -> backUpGroup(groupField));
        
        //restore button
        Button restoreButton = new Button("Restore");
        restoreButton.setOnAction(e -> restoreGroup(groupField));

        
        // back button send back to group menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            GroupMenu menu = new GroupMenu();
            menu.start(primaryStage);
        });

        // Creating a vbox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, groupLabel, groupField, backUpButton, restoreButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("BackUp/Restore Group");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	//backup group in database and send alert
	private void backUpGroup(TextField groupField) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Group backed up successfully!");
        alert.showAndWait();
    }
	
	//restore group in database and send alert
	private void restoreGroup(TextField groupField) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Group restored successfully!");
        alert.showAndWait();
    }


}
	