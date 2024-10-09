// The list of accounts that the Admin can see
package AccList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class AccountList extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		// Creating a heading
		Label headingLabel = new Label("List of Accounts");
		
		// List labels
		Label usernameLabel = new Label("Username");
		Label roleLabel = new Label("Role");
		
		// Button to logout
		Button logoutButton = new Button("Yes, logout of this account");
	    logoutButton.setOnAction((e) -> {
	    	LogoutScreenGP logoutScrn = new LogoutScreenGP();
	    	logoutScrn.start(primaryStage);
	    });
	    
	    // Creating Hbox to hold labels and button
	    HBox hBox = new HBox(10);
	    hBox.setAlignment(Pos.CENTER);
	    hBox.getChildren().addAll(usernameLabel, roleLabel, logoutButton);
	    
	    VBox vbox = new VBox(20);
	    vbox.setAlignment(Pos.CENTER);
	    vbox.getChildren().addAll(headingLabel, hBox);
	    // list will go under hbox
	}
	
}
