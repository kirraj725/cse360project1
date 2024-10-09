package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResetPWAdminGP extends Application {
   public void start(Stage primaryStage) {
      Label instructionLabel = new Label("Enter E-mail");
      Label emailLabel = new Label("Email:");
      TextField emailField = new TextField();
      HBox emailBox = new HBox(10);
      emailBox.setAlignment(Pos.CENTER);
      emailBox.getChildren().addAll(emailLabel, emailField);
      Button sendButton = new Button("Send");
      // add action to send email
      Button backButton = new Button("Back");
      // add action to send back to the account list
      VBox vbox = new VBox(20);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(instructionLabel, emailBox, sendButton, backButton);
      Scene scene = new Scene(vbox, 400, 300);
      primaryStage.setTitle("Reset Password Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
