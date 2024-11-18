// this is the screen a student can use to search for articles

package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SearchScreen extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// creating a heading
		Label header = new Label("Search Articles");
		
		// searching by content
		Label contentLabel = new Label("Select Content Level:");
        CheckBox beginnerCheck = new CheckBox("Beginner");
        CheckBox intermediateCheck = new CheckBox("Intermediate");
        CheckBox advancedCheck = new CheckBox("Advanced");
        CheckBox expertCheck = new CheckBox("Expert");
        CheckBox allCheck = new CheckBox("All");
        allCheck.setSelected(true); 
        
        // searching by group
        Label groupLabel = new Label("Select Group:");
        ComboBox<String> groupDropdown = new ComboBox<>();
        groupDropdown.getItems().addAll("All", "Assignment 1", "Assignment 2", "Final Project"); // Example groups
        groupDropdown.setValue("All");
        
        // searching by keyword
        Label keywordLabel = new Label("Search by Title, Author, or Abstract:");
        TextField keywordField = new TextField();
        keywordField.setPromptText("Enter keywords, title, or author...");
        
        // searching by ID
        Label idLabel = new Label("Search by Unique Identifier:");
        TextField idField = new TextField();
        idField.setPromptText("Enter unique ID...");
        
        // search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            // Navigate to a new results screen (not implemented yet)
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Triggered");
            alert.setHeaderText(null);
            alert.setContentText("Search functionality not implemented yet.");
            alert.showAndWait();
        });
        
        // button to go back to StudentMenu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
        	StudentMenu StuMenu = new StudentMenu();
        	StuMenu.start(primaryStage);
        });
        
     // Layout for Content Level
        VBox contentLevelBox = new VBox(5, beginnerCheck, intermediateCheck, advancedCheck, expertCheck, allCheck);
        contentLevelBox.setPadding(new Insets(10));

        // Layout for Group and Search Inputs
        VBox searchInputs = new VBox(10, contentLabel, contentLevelBox, groupLabel, groupDropdown, 
                                      keywordLabel, keywordField, idLabel, idField);
        searchInputs.setAlignment(Pos.CENTER_LEFT);
        searchInputs.setPadding(new Insets(20));

        // vbox to hold everything on top of each other
        VBox vbox = new VBox(20, header, searchInputs, searchButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setTitle("Search Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
