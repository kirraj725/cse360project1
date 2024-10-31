// this is the class where a user can create a new article

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.SQLException;


public class CreateArt extends Application
{
	private static DatabaseHelper databaseHelper;
	@Override
	public void start(Stage primaryStage) {
		// Creating the headings
		Label headingLabel = new Label("Create a new article!");
		
		// unique header label and area for input
		Label uhLabel = new Label("Header:");
		TextField uhField = new TextField();
		
		// title label and field for input
		Label titleLabel = new Label("Title:");
		TextField titleField = new TextField();
		
		// description label and area for input
		Label descLabel = new Label("Description:");
		TextArea descArea = new TextArea();
		
		// keyword label and field for input
		Label kwLabel = new Label("Keywords:");
		TextField kwField = new TextField();
		
		// body label and area for input
		Label bodyLabel = new Label("Body:");
		TextArea bodyArea = new TextArea();
		
		// link label and area for input
		Label linkLabel = new Label("References*:");
		TextArea linkArea = new TextArea();
		
		// Miscellaneous label and area for input
		Label miscLabel = new Label("Miscellanous*:");
		TextArea miscArea = new TextArea();
		
        // Labels and fields will be arranged in a gridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(uhLabel, 0, 0);
        gridPane.add(uhField, 1, 0);
        gridPane.add(titleLabel, 0, 1);
        gridPane.add(titleField, 1, 1);
        gridPane.add(descLabel, 0, 2);
        gridPane.add(descArea, 1, 2);
        gridPane.add(kwLabel, 0, 3);
        gridPane.add(kwField, 1, 3);
        gridPane.add(bodyLabel, 0, 4);
        gridPane.add(bodyArea, 1, 4);
        gridPane.add(linkLabel, 0, 5);
        gridPane.add(linkArea, 1, 5);
        gridPane.add(miscLabel, 0, 6);
        gridPane.add(miscArea, 1, 6);
		
        // Label for optional fields
        Label optionalFieldsLabel = new Label("*Optional, can be left blank");
        
        String header = uhField.getText();
        String title = titleField.getText();
        String description = descArea.getText();
        String keywords = kwField.getText();
        String body = bodyArea.getText();
        String references = linkArea.getText();
        String misc = miscArea.getText();
        
        // Creating the continue buton to create the article
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
        	validateAndProceed(uhField, titleField, descArea, kwField, bodyArea, primaryStage, linkArea, miscArea);
        		//databaseHelper.storeArticle(header, title, description, keywords, body, references, misc); 
        		System.out.println("Help System setup completed.");
        });
		
		// Back button
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
        	ArticleMenuManagement artMenuMan = new ArticleMenuManagement();
        	artMenuMan.start(primaryStage);
		});
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(headingLabel, gridPane, optionalFieldsLabel, createButton, backButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 1000, 1000);
        primaryStage.setTitle("Create Article Page");
        primaryStage.setScene(scene);
        primaryStage.show(); 
	}
	
	// Ensuring there are no empty textFields
	private void validateAndProceed(TextField uhField, TextField titleField, TextArea descArea, TextField kwField, TextArea bodyArea, Stage primaryStage, TextArea linkArea, TextArea miscArea)
	{
		if (uhField.getText().isEmpty() ||titleField.getText().isEmpty() || descArea.getText().isEmpty() || kwField.getText().isEmpty() || bodyArea.getText().isEmpty())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Incomplete Form");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all required fields.");
			alert.showAndWait();			
		}
		else
		{
		    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		    successAlert.setTitle("Article Created");
		    successAlert.setHeaderText(null);
		    successAlert.setContentText("The article has been successfully created!");
		    successAlert.showAndWait();
		    
		    titleField.clear();
		    descArea.clear();
		    kwField.clear();
		    bodyArea.clear();
		    linkArea.clear();
		    miscArea.clear();

		    ArticleMenuManagement artMenuMan = new ArticleMenuManagement();
		    artMenuMan.start(primaryStage);
		}
	}
}
