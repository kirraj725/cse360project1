//main driver class
package TEST1Phase1;

//import java.sql.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSE360GPTest1 extends Application {
	
//	public static final CSVfileHandler CSVfile = new CSVfileHandler("src/resources/data_csv.csv");
	
	public void start(Stage primaryStage)
	{
		//Using csv file handler to decide if this is the very first user or a regular user
		CSVfileHandler CSVfile = new CSVfileHandler("src/resources/csv_empty.csv");
		if (CSVfile.isCSVFileEmpty("src/resources/csv_empty.csv")) {
			System.out.println( "File is empty" );
			//set up administrator access
			VFLPTest1 veryFirstPage = new VFLPTest1();
			veryFirstPage.start(primaryStage);
	        
		}
		else {
			OLSTest1 originalScreen = new OLSTest1();
			originalScreen.start(primaryStage);
		}
	}
	
	
		
		
		//testing 
		
//		UserTest1 newUser = new UserTest1("jane", "janny", "may", "doe", "janedoe@asu.edu", "jdoe4", 12345, "student");
//		System.out.println(newUser.getFirstName());
//		System.out.println(newUser.getLastName());
//		System.out.println(newUser.getEmailAddress());
//		System.out.println(newUser.getPassword());

	//Launching the driver method
	public static void main(String[] args)
	{
		launch(args);
	}
    
}
