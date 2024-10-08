// This is the login page for the very first user.
package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VeryFirstLoginPage extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating the headings
		Label welcomeLabel = new Label("Welcome!");
		Label instructionLabel = new Label("Please create a username and password:");
		
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
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(reenterPasswordLabel, 0, 2);
        gridPane.add(reenterPasswordField, 1, 2);
        
        // Creating the continue button to move on to the next screen if passwords match
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> validateAndProceed(usernameField, passwordField, reenterPasswordField, primaryStage));
        
        // Creating a VBox to put welcome message on top of gridPane
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(welcomeLabel, instructionLabel, gridPane, continueButton);
        
        // Creating scene and showing stage
        Scene scene = new Scene(vbox, 400, 250);
        primaryStage.setTitle("Very First Login Page");
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
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}