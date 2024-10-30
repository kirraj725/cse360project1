// this is the class where a user can delete a new article

package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteArt extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("Delete an Article");
		
		// id label and field for input
        Label idLabel = new Label("Enter Article ID:");
        TextField idField = new TextField();
        
        // Delete button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteArticle(idField));
        
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            ArticleMenuManagement menu = new ArticleMenuManagement();
            menu.start(primaryStage);
        });

        // Creating a vbox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, idLabel, idField, deleteButton, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Delete Article");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	// Deleting an article in data structure
	private void deleteArticle(TextField idField) 
	{
		String articleId = idField.getText();

	    if (articleId.isEmpty()) 
	    {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText("Please enter an article ID.");
	            alert.showAndWait();
	            return;
	    }
	    
	    boolean success = deleteArticleById(articleId);
	    Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
	    alert.setContentText(success ? "Article deleted successfully!" : "Article not found.");
	    alert.showAndWait();
	}
	
    private boolean deleteArticleById(String articleId) 
    {
        // Implement logic to delete the article by ID in your data structure or database
        return true;
    }

}
	