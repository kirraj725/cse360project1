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


public class AInvTest1 extends Application {
   public void start(Stage primaryStage) {
	   Label pickRoleLabel = new Label("Pick a temporary role for invitation:");
	      Button AdminButton = new Button("Admin");
	      Button instructorButton = new Button("Instructor");
	      Button StudentButton = new Button("Student");
	      Label EmailLabel = new Label("Email:");
	      TextField emailField = new TextField();
	      Button SendButton = new Button("Send");
	      Button backButton = new Button("Back");
	      //add action
	      HBox emailBox = new HBox(10);
	      emailBox.setAlignment(Pos.CENTER);
	      emailBox.getChildren().addAll(EmailLabel, emailField);
	      HBox buttonBox = new HBox(10);
	      buttonBox.setAlignment(Pos.CENTER);
	      buttonBox.getChildren().addAll(AdminButton, instructorButton, StudentButton);
	      VBox vbox = new VBox(20);
	      vbox.setAlignment(Pos.CENTER);
	      vbox.getChildren().addAll(pickRoleLabel, buttonBox,emailBox, SendButton, backButton);
	      Scene scene = new Scene(vbox, 400, 400);
	      primaryStage.setTitle("Admin Invitation Page");
	      primaryStage.setScene(scene);
	      primaryStage.show();
   
	      
   }
   
   public static void main(String[] args)
   {
	   launch(args);
   }
}