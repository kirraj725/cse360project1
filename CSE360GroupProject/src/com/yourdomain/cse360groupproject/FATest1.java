// This is the screen to finish setting up a user's account
package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FATest1 extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label headingLabel = new Label("Finish setting up your account!");
		
		// Email label and field for input
		Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        // First name label and field for input
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        
        // Middle name label and field for input
        Label middleNameLabel = new Label("Middle Name*:");
        TextField middleNameField = new TextField();
        
        // Last name label and field for input
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        
        // Preferred name label and field for input
        Label preferredNameLabel = new Label("Preferred Name:");
        TextField preferredNameField = new TextField();
        
        // Labels and fields will be arranged in a gridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);
        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(firstNameField, 1, 1);
        gridPane.add(middleNameLabel, 0, 2);
        gridPane.add(middleNameField, 1, 2);
        gridPane.add(lastNameLabel, 0, 3);
        gridPane.add(lastNameField, 1, 3);
        gridPane.add(preferredNameLabel, 0, 4);
        gridPane.add(preferredNameField, 1, 4);
        
        // Label for optional fields
        Label optionalFieldsLabel = new Label("*Optional, can be left blank");
        
        // Creating the continue button to move on to the next screen
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> validateAndProceed(emailField, firstNameField, lastNameField, preferredNameField, primaryStage));
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(headingLabel, gridPane, optionalFieldsLabel, continueButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 450);
        primaryStage.setTitle("Finish Account Setup Page");
        primaryStage.setScene(scene);
        primaryStage.show(); 
	}
	
	// Ensuring there are no empty textFields
	private void validateAndProceed(TextField emailField, TextField firstNameField, TextField lastNameField, TextField preferredNameField, Stage primaryStage)
	{
		if (emailField.getText().isEmpty() || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || preferredNameField.getText().isEmpty())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Incomplete Form");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all required fields.");
			alert.showAndWait();			
		}
		else
		{
			String preferredName = preferredNameField.getText().isEmpty() ? firstNameField.getText() : preferredNameField.getText();
			RSTest1 roleSel = new RSTest1(preferredName);
			roleSel.start(primaryStage);
		}
	}
	
}

