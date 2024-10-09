package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;


public class AdminInvGPreal extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//anchor pane
			AnchorPane root = new AnchorPane();

			//set stage title
			primaryStage.setTitle("Admin Invitation");
		    
			//set stage max height and width
			primaryStage.setMaxHeight(400);
			primaryStage.setMaxWidth(400);
			
			//text prompt for role invitation
			Text promptTxt = new Text("Pick a Temporary Role for Invitation:");
			//text prompt for email
			Text emailTxt = new Text("Email:");
			TextField boxTxt = new TextField();
			
			//button event for admin, instructor, student, send, and back
		    Button btnAdmin = new Button();
			Button btnInstr = new Button();
			Button btnStud = new Button();
			Button btnSend = new Button();
			Button btnBack = new Button();
	        btnAdmin.setText("Admin");
	        btnInstr.setText("Instructor");
	        btnStud.setText("Student");
	        btnSend.setText("Send");
	        btnBack.setText("Back");
	        
	        //button positioning 
	        btnAdmin.setLayoutX(50);
	        btnAdmin.setLayoutY(100);
	        btnInstr.setLayoutX(150);
	        btnInstr.setLayoutY(100);
	        btnStud.setLayoutX(250);
	        btnStud.setLayoutY(100);
	        btnSend.setLayoutX(165);
	        btnSend.setLayoutY(250);
	        btnBack.setLayoutX(165);
	        btnBack.setLayoutY(325);
	        promptTxt.setLayoutX(100);
	        promptTxt.setLayoutY(50);
	        emailTxt.setLayoutX(75);
	        emailTxt.setLayoutY(200);
	        boxTxt.setLayoutX(115);
	        boxTxt.setLayoutY(185);
	        
	        //adds the button and text prompts into the root
	        root.getChildren().add(btnAdmin);
	        root.getChildren().add(btnInstr);
	        root.getChildren().add(btnStud);
	        root.getChildren().add(promptTxt);
	        root.getChildren().add(emailTxt);
	        root.getChildren().add(boxTxt);
	        root.getChildren().add(btnSend);
	        root.getChildren().add(btnBack);
	        
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
