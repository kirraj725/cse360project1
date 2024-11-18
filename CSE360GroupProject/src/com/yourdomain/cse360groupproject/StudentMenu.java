// Menu of options that a student has when navigating the system

package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentMenu extends Application
{
	@Override
    public void start(Stage primaryStage)
    {
		// creating a heading
		Label header = new Label("Student Menu");
		
		// button to logout
		Button logoutButton = new Button("Logout");
		logoutButton.setOnAction(e -> {
	    	LogoutScreen logoutScrn = new LogoutScreen();
	    	logoutScrn.start(primaryStage);
	    });
		
		// button to search for articles
		Button searchButton = new Button("Search Articles");
		searchButton.setOnAction(e -> {
			SearchScreen srchScrn = new SearchScreen();
			srchScrn.start(primaryStage);
        });
		
		// button to get help with system (generic message)
		Button systemHelpButton = new Button("System Help");
		systemHelpButton.setOnAction(e -> {
			SysHelp systemHelp = new SysHelp();
			systemHelp.start(primaryStage);
        });
		
		// button to give suggestions (specific message)
		Button suggestionButton = new Button("Leave a Suggestion");
		suggestionButton.setOnAction(e -> {
			SuggScreen suggScrn = new SuggScreen();
	    	suggScrn.start(primaryStage);
        });

		// creating VBox to hold buttons on top of each other
		VBox vbox = new VBox(15); // 15 px spacing
        vbox.getChildren().addAll(header, searchButton, systemHelpButton, suggestionButton, logoutButton);
        vbox.setAlignment(Pos.CENTER);
        
        // setting scene and showing stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Student Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) 
	{
        launch(args);
    }
}
