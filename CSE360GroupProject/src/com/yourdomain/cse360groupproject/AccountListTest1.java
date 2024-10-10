// The list of accounts that the Admin can see
package TEST1Phase1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class AccountListTest1 extends Application
{
	private TableView<UserTest1> listView;
	
	@Override
	public void start(Stage primaryStage)
	{
		// Creating a heading
		Label headingLabel = new Label("List of Accounts");
		
		// Creating a new tableView of our data
		listView = new TableView<>();
		
		// Columns for username, preferred name, and role
		TableColumn<UserTest1, String> usernameColumn = new TableColumn<>("Username");
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		
		TableColumn<UserTest1, String> pnameColumn = new TableColumn<>("Preferred Name");
		pnameColumn.setCellValueFactory(new PropertyValueFactory<>("preferredName"));
		
		TableColumn<UserTest1, String> roleColumn = new TableColumn<>("Roles");
		roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
		
		// Add columns to the table
		listView.getColumns().add(usernameColumn);
		listView.getColumns().add(pnameColumn);
		listView.getColumns().add(roleColumn);
		
		// Load data from csv
		//loadDataFromCSV();
		
		// Button for Management menu
		Button mngMenu = new Button ("Account Management Menu");
		mngMenu.setOnAction(e -> {
			AMenuTest1 AdminMenu = new AMenuTest1();
			AdminMenu.start(primaryStage);
			
		});
		
		
		// Button to logout
		Button logoutButton = new Button("Yes, logout of this account");
	    logoutButton.setOnAction(e -> {
	    	LOSTest1 logoutScrn = new LOSTest1();
	    	logoutScrn.start(primaryStage);
	    });
	    
	    
	    
	    VBox vbox = new VBox(20);
	    vbox.setAlignment(Pos.CENTER);
	    vbox.getChildren().addAll(headingLabel, mngMenu, listView, logoutButton);
	    
	    Scene scene = new Scene(vbox, 500, 500);
	    primaryStage.setTitle("Accounts List");
        primaryStage.setScene(scene);
        primaryStage.show();
	    // list will go under hbox
	}
	
	
	// Method for loading data from csv
//	private void loadDataFromCSV()
//	{
//		CSVfileHandler csvHandler = new CSVfileHandler("src/resources/data_csv.csv");
//		List<String[]> usersData = csvHandler.readFromCSV();
//		
//		System.out.println("test1");
//		for (String[] userData : usersData)
//		{
//			System.out.println("test2 for loop");
//			if (userData.length >= 8)
//			{
//				
//				System.out.println("test3 if loop");
//				String firstName = userData[0];
//				String preferredName = userData[1];
//				String middleName = userData[2];
//				String lastName = userData[3];
//				String emailAddress = userData[4];
//				String username = userData[5];
//				int password = Integer.parseInt(userData[6]);
//				String role = userData[7];
//				System.out.println("test4 for loop");
//				UserTest1 user = new UserTest1(firstName, preferredName, middleName, lastName, emailAddress, username, password, role);
//				System.out.println("test5 for loop");
//				listView.getItems().add(user);
//			}
//		}
//	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
}





/*// Method for loading data from csv
private void loadDataFromCSV()
{
	CSVfileHandler csvHandler = new CSVfileHandler("src/resources/data_csv.csv");
	List<String[]> usersData = csvHandler.readFromCSV();
	
	for (String[] userData : usersData)
	{
		if (userData.length >= 8)
		{
			String firstName = userData[0];
			String preferredName = userData[1];
			String middleName = userData[2];
			String lastName = userData[3];
			String emailAddress = userData[4];
			String username = userData[5];
			int password = Integer.parseInt(userData[6]);
			String role = userData[7];
			
			UserTest1 user = new UserTest1(firstName, preferredName, middleName, lastName, emailAddress, username, password, role);
			listView.getItems().add(user);
		}
	}
}
*/