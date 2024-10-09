package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogoutScreenGP extends Application {
   public void start(Stage primaryStage) {
      Label logoutLabel = new Label("Would you like to logout of this account?");
      Button logoutButton = new Button("Yes, logout of this account");
      logoutButton.setOnAction((e) -> {
         OriginalLoginScreenGP oriLogin = new OriginalLoginScreenGP();
         oriLogin.start(primaryStage);
      });
      Button backButton = new Button("Back");
      // add action of back button to take back to acc list
      VBox vbox = new VBox(20);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(logoutLabel, logoutButton, backButton);
      Scene scene = new Scene(vbox, 300, 200);
      primaryStage.setTitle("Logout Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
