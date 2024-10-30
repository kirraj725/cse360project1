// this is the class where a user can view an article

package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewArt extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// Creating the heading
		Label headingLabel = new Label("View an Article");
		
		// id label and field for input
        Label idLabel = new Label("Enter Article ID:");
        TextField idField = new TextField();
        
        //article details
        TextArea articleDetails = new TextArea();
        articleDetails.setEditable(false);
        
        // view button
        Button viewButton = new Button("View");
        viewButton.setOnAction(e -> viewArticle(idField, articleDetails));
        
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            ArticleMenuManagement menu = new ArticleMenuManagement();
            menu.start(primaryStage);
        });
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20, headingLabel, idLabel, idField, viewButton, articleDetails, backButton);
        vbox.setAlignment(Pos.CENTER);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("View Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	// Retrieve the article by ID and display details
	private void viewArticle(TextField idField, TextArea articleDetails) 
	{
        String articleId = idField.getText();

        if (articleId.isEmpty()) 
        {
            articleDetails.setText("Please enter an article ID.");
            return;
        }

        articleDetails.setText("Displaying article details for ID: " + articleId);
    }
}
