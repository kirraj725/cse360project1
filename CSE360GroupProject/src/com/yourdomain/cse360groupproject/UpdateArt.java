// this is the class where a user can update an article

package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateArt extends Application 
{
	@Override
    public void start(Stage primaryStage)
    {
		// Creating the heading
		Label headingLabel = new Label("Update an Article");
		
		// id label and field for input
        Label idLabel = new Label("Enter Article ID:");
        TextField idField = new TextField();
        
		// title label and field for input
		Label titleLabel = new Label("Title:");
		TextField titleField = new TextField();
		
		// body label and area for input
		Label bodyLabel = new Label("Body:");
		TextArea bodyArea = new TextArea();
		
		// search button
		Button searchButton = new Button("Search");
		searchButton.setOnAction(e -> loadArticle(idField, titleField, bodyArea));
		
		// update button
	    Button updateButton = new Button("Update");
	    updateButton.setOnAction(e -> updateArticle(idField, titleField, bodyArea));
	    
	    // back button
	    Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            ArticleMenuManagement menu = new ArticleMenuManagement();
            menu.start(primaryStage);
        });
        
        // Labels and fields will be arranged in a gridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(searchButton, 2, 0);
        gridPane.add(titleLabel, 0, 1);
        gridPane.add(titleField, 1, 1);
        gridPane.add(bodyLabel, 0, 2);
        gridPane.add(bodyArea, 1, 2);
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, gridPane, updateButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("Update Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	// Load article details by ID and set the values in titleField and bodyArea
	private void loadArticle(TextField idField, TextField titleField, TextArea bodyArea) 
	{
        
    }
	
    // Update article details in the database or data structure
    private void updateArticle(TextField idField, TextField titleField, TextArea bodyArea) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Article updated successfully!");
        alert.showAndWait();
    }
}
