package groupProjectScreens;

import com.yourdomain.cse360groupproject.Button;
import com.yourdomain.cse360groupproject.HBox;
import com.yourdomain.cse360groupproject.Label;
import com.yourdomain.cse360groupproject.VBox;

import javafx.application.Application;
import javafx.stage.Stage;

public class AddRemoveRolegp extends Application {
   public void start(Stage primaryStage) {
	   Label headingLabel = new Label("Pick a Role");
	   Button AdminButton = new Button("Admin");
	   Button instructorButton = new Button("Instructor");
	   Button StudentButton = new Button("Student");
	      Button backButton = new Button("Back");
	      HBox buttonBox = new HBox(10);
	      buttonBox.setAlignment(Pos.CENTER);
	      buttonBox.getChildren().addAll(AdminButton, instructorButton, StudentButton);
	      VBox vbox = new VBox(20);
	      vbox.setAlignment(Pos.CENTER);
	      vbox.getChildren().addAll(headingLabel, buttonBox, backButton);
          
          
    }
	   
   }
