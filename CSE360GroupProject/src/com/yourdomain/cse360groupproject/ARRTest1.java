package TEST1Phase1;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ARRTest1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//anchor pane
			AnchorPane root = new AnchorPane();
			
			//set stage title
			primaryStage.setTitle("Add or Remove Roles");
			
			//set stage max height and width
			primaryStage.setMaxHeight(400);
			primaryStage.setMaxWidth(400);

			//set Title text
			Text promptTxt = new Text("Pick a Role:");
			Font font = Font.font("Verdana", FontWeight.BOLD, 20);
			promptTxt.setFont(font);
			
			//set checkboxs for admin, student, and instructor
			CheckBox adminBox = new CheckBox("Admin");
			CheckBox studentBox = new CheckBox("Student");
			CheckBox instructorBox = new CheckBox("Instructor");
			
			//set buttons for done and back
			Button btnBack = new Button();
			btnBack.setText("Back");
			
			// Create a label to display the message
	        Label adminLabel = new Label();
	        Label studentLabel = new Label();
	        Label instructorLabel = new Label();
	        
	        // Add an event handler to the checkbox to display message when checked for admin
	        adminBox.setOnAction(e -> {
	            if (adminBox.isSelected()) {
	                adminLabel.setText("User assigned Admin role!");
	            } else {
	                adminLabel.setText("");
	            }
	        });
	        // Add an event handler to the checkbox to display message when checked for student
	        studentBox.setOnAction(e -> {
	        	if (studentBox.isSelected()) {
	        		studentLabel.setText("User assigned Student role!");
	        	} else {
	        		studentLabel.setText("");
	        		}
	        });
	        // Add an event handler to the checkbox to display message when checked for instructor
	        instructorBox.setOnAction(e -> {
	        	if (instructorBox.isSelected()) {
	        		instructorLabel.setText("User assigned Instructor role!");
	        	} else {
	        		instructorLabel.setText("");
	        		}
	        });
	        
			//positioning for check boxes, texts, and buttons
			btnBack.setLayoutX(175);
			btnBack.setLayoutY(325);
			adminBox.setLayoutX(50);
			adminBox.setLayoutY(225);
			studentBox.setLayoutX(150);
			studentBox.setLayoutY(225);
			instructorBox.setLayoutX(250);
			instructorBox.setLayoutY(225);
	        promptTxt.setLayoutX(100);
	        promptTxt.setLayoutY(50);
	        adminLabel.setLayoutX(25);
	        adminLabel.setLayoutY(250);
	        studentLabel.setLayoutX(115);
	        studentLabel.setLayoutY(250);
	        instructorLabel.setLayoutX(215);
	        instructorLabel.setLayoutY(250);
	        

	        //adds the check boxes, buttons, and text prompts into the root
	        root.getChildren().add(adminBox);
	        root.getChildren().add(studentBox);
	        root.getChildren().add(instructorBox);
	        root.getChildren().add(promptTxt);
	        root.getChildren().add(btnBack);
	        root.getChildren().add(adminLabel);
	        root.getChildren().add(studentLabel);
	        root.getChildren().add(instructorLabel);
	        
	        //HBox hbox = new HBox(btnAdmin, btnInstr, btnStud);
	        /*
	        btnAdmin.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	                System.out.println("ASU: Hello World!");
	            }
	        });
	        */

			//scene
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//main to launch
	public static void main(String[] args) {
		launch(args);
	}
}