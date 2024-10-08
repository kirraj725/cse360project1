// This is the screen where the user can select their role
package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoleSelection extends Application
{
	// Variables for constructor
	private String preferredName;
	
	// Constructor to pass the preferred name and first name
	public RoleSelection(String preferredName)
	{
		this.preferredName = preferredName;
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the heading
		Label headingLabel = new Label("Welcome " + preferredName + "! Please select role!");
		
		// Buttons for Role Selection
		Button adminButton = new Button("Admin");
		adminButton.setOnAction(e -> System.out.println("Admin role selected."));
		
        Button instructorButton = new Button("Instructor");
        instructorButton.setOnAction(e -> System.out.println("Instructor role selected."));
        
        Button studentButton = new Button("Student");
        studentButton.setOnAction(e -> System.out.println("Student role selected."));
        
        // Creating VBox to hold buttons on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(headingLabel, adminButton, instructorButton, studentButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Role Selection Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
	}
}