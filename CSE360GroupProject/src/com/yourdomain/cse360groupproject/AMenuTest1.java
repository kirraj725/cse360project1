package TEST1Phase1;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class AMenuTest1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//anchor pane
			AnchorPane root = new AnchorPane();

			//set stage title
			primaryStage.setTitle("Admin Menu");
		    
			//set stage max height and width
			primaryStage.setMaxHeight(400);
			primaryStage.setMaxWidth(400);
			
			//text prompt for role invitation
			Text promptTxt = new Text("Admin Menu");
			Font font = Font.font("Verdana", FontWeight.BOLD, 20);
			promptTxt.setFont(font);
			//text prompt for email
						
			//button event for admin, instructor, student, send, and back
		    Button btnDelete = new Button();
			Button btnReset = new Button();
			Button btnInvitation = new Button();
			Button btnAddRemove = new Button();
			/*
			Button btnSend = new Button();
			Button btnBack = new Button();
			*/
	        btnDelete.setText("Delete User Account");
	        btnReset.setText("Reset Password");
	        btnInvitation.setText("Admin Invitation");
	        btnAddRemove.setText("Add/Remove Roles");
	        /*
	        btnSend.setText("Send");
	        btnBack.setText("Back");
	        */
	        
	        //button positioning 
	        promptTxt.setLayoutX(100);
	        promptTxt.setLayoutY(50);
	        btnDelete.setLayoutX(135);
	        btnDelete.setLayoutY(75);
	        btnReset.setLayoutX(135);
	        btnReset.setLayoutY(125);
	        btnInvitation.setLayoutX(135);
	        btnInvitation.setLayoutY(175);
	        btnAddRemove.setLayoutX(135);
	        btnAddRemove.setLayoutY(225);
	        /*
	        btnBack.setLayoutX(165);
	        btnBack.setLayoutY(325);
	        */
	      	        	        
	        //adds the button and text prompts into the root
	        root.getChildren().add(btnDelete);
	        root.getChildren().add(btnReset);
	        root.getChildren().add(btnInvitation);
	        root.getChildren().add(btnAddRemove);
	        root.getChildren().add(promptTxt);
	        /*
	        root.getChildren().add(btnSend);
	        root.getChildren().add(btnBack);
	        */
	        
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
