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
      HBox emailBox = new HBox(10.0D);
      emailBox.setAlignment(Pos.CENTER);
      emailBox.getChildren().addAll(new Node[]{emailLabel, emailField});
      Button sendButton = new Button("Send");
      Button backButton = new Button("Back");
      VBox vbox = new VBox(20.0D);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(new Node[]{instructionLabel, emailBox, sendButton, backButton});
      Scene scene = new Scene(vbox, 400.0D, 300.0D);
      primaryStage.setTitle("Reset Password Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
