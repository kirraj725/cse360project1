// This is the login screen for new users
package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NULogin extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label welcomeLabel = new Label("Welcome!");
		Label instructionLabel = new Label("Please fill out the invitation code and create a username and password:");
		
		// Invitation code label and field for input
		Label invitationCodeLabel = new Label("Invitation Code:");
		TextField invitationCodeField = new TextField();
		
		// Username label and field for input
		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		        
        // Password label and field for input
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
		        
        // Re-enter password label and field for input
        Label reenterPasswordLabel = new Label("Re-enter Password:");
        PasswordField reenterPasswordField = new PasswordField();
        
        // Labels and fields will be arranged in a gridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(invitationCodeLabel, 0, 0);
        gridPane.add(invitationCodeField, 1, 0);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(reenterPasswordLabel, 0, 3);
        gridPane.add(reenterPasswordField, 1, 3);
        
        // Creating the continue button to move on to the next screen if passwords match and invitation code is correct
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> validateAndProceed(usernameField, passwordField, reenterPasswordField, primaryStage));
        
        // Creating VBox to hold everything on top of each other
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(welcomeLabel, instructionLabel, gridPane, continueButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("New User Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	// Ensuring there are no empty textFields and passwords match
	private void validateAndProceed(TextField usernameField, PasswordField passwordField, PasswordField reenterPasswordField, Stage primaryStage)
	{
		if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || reenterPasswordField.getText().isEmpty())
		{
			showAlert("Please fill in all fields.");
		}
		else if (!passwordField.getText().equals(reenterPasswordField.getText()))
		{
			showAlert("Passwords do not match.");
		}
		else
		{
			OriginalLoginScreen oriLogin = new OriginalLoginScreen();
			oriLogin.start(primaryStage);
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