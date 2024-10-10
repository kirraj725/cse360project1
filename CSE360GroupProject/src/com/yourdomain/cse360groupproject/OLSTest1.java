// This is the original login screen that everyone will see when they login
package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OLSTest1 extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label welcomeLabel = new Label("Welcome!");
		Label instructionLabel = new Label("Please enter your username and password:");
				
		// Username label and field for input
		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		        
		// Password label and field for input
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField = new PasswordField();
		
		// Labels and fields will be arranged in a gridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        
        // Creating continue button and new user button to move on to new screens
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> validateAndProceed(usernameField, passwordField, primaryStage));
        
        Button newUserButton = new Button("I am a new user");
        newUserButton.setOnAction(e -> {
        	NULTest1 nuLogin = new NULTest1();
        	nuLogin.start(primaryStage);
        });
        
        // Creating an HBox to hold buttons side by side
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(continueButton, newUserButton);
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(welcomeLabel, instructionLabel, gridPane, buttonBox);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 350);
        primaryStage.setTitle("Original Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	
	// Ensuring there are no empty textFields
	private void validateAndProceed(TextField usernameField, PasswordField passwordField, Stage primaryStage)
	{
		if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty())
		{
			showAlert("Please fill in your username and password.");
		}
		else
		{
			FATest1 finishAccount = new FATest1();
			finishAccount.start(primaryStage);
		}
	}
	
	// Alert messages
	private void showAlert(String message)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}

