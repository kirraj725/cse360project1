//This is the screen where admin sends an email to help users reset their passwords
package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RPWTest1 extends Application {
   public void start(Stage primaryStage) {
      //Creating an instruction label
      Label instructionLabel = new Label("Enter E-mail");
      //Creating a label and textfield for email
      Label emailLabel = new Label("Email:");
      TextField emailField = new TextField();
      //HBox to hold email label and textfield together
      HBox emailBox = new HBox(10);
      emailBox.setAlignment(Pos.CENTER);
      emailBox.getChildren().addAll(emailLabel, emailField);
      Button sendButton = new Button("Send");
      // Button to go back to the account list screen
      Button backButton = new Button("Back");
      backButton.setOnAction(e -> {
  	  		AccountListTest1 AccList = new AccountListTest1();
    		AccList.start(primaryStage);	  
      });
      //Used to hold everything on top of eachother
      VBox vbox = new VBox(20);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(instructionLabel, emailBox, sendButton, backButton);
      //Showing stage and setting scene
      Scene scene = new Scene(vbox, 400, 300);
      primaryStage.setTitle("Reset Password Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}


