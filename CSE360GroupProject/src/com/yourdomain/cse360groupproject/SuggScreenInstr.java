// this is the screen where students can leave suggestions about topics they cannot find articles for (specific message)

package com.yourdomain.cse360groupproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SuggScreenInstr extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating a heading
		Label header = new Label("Leave a Suggestion");
		
		// label for textArea
		Label suggLabel = new Label("Enter your suggestion here: ");
		
		// creating a textArea to leave suggestions
		TextArea suggestionArea = new TextArea();
		suggestionArea.setPrefSize(300, 150);
		
		// button to submit suggestion
		Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String suggestion = suggestionArea.getText();
            if (!suggestion.trim().isEmpty()) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Suggestion Submitted");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Your suggestion has been successfully submitted!");
                successAlert.showAndWait();
                System.out.println("Suggestion submitted: " + suggestion);
                suggestionArea.clear();
            } else {
                Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                warningAlert.setTitle("Empty Suggestion");
                warningAlert.setHeaderText(null);
                warningAlert.setContentText("Please enter a suggestion before submitting.");
                warningAlert.showAndWait();
            }
        });
        
        // button to go back to StudentMenu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
        	SearchBasic StuMenu = new SearchBasic();
        	StuMenu.start(primaryStage);
        });
        
        // creating HBox to hold label and textArea together
        HBox suggestionBox = new HBox(10);
        suggestionBox.getChildren().addAll(suggLabel, suggestionArea);
        suggestionBox.setAlignment(Pos.CENTER_LEFT);
        
        // creating vbox to hold everything on top of each other
        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(header, suggestionBox, submitButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setTitle("Leave a Suggestion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
