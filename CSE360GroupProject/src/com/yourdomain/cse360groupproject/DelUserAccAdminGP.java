package groupProjectScreens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DelUserAccAdminGP extends Application {
   public void start(Stage primaryStage) {
      Label delAccLabel = new Label("Would you like to delete this account?");
      Button delAccButton = new Button("Yes, delete this account");
      Button backButton = new Button("Back");
      VBox vbox = new VBox(20.0D);
      vbox.setAlignment(Pos.CENTER);
      vbox.getChildren().addAll(new Node[]{delAccLabel, delAccButton, backButton});
      Scene scene = new Scene(vbox, 300.0D, 200.0D);
      primaryStage.setTitle("Account Deletion Page");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
