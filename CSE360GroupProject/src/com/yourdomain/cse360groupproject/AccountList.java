// The list of accounts that the Admin can see
package com.yourdomain.cse360groupproject;

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

public class AccountList extends Application
{
	private TableView<User> listView;
	
	@Override
	public void start(Stage primaryStage)
	{
		// Creating a heading
		Label headingLabel = new Label("List of Accounts");
		
		// Creating a new tableView of our data
		listView = new TableView<>();
		
		// Columns for username, preferred name, and role
		TableColumn<User, String> firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<User, String> pnameColumn = new TableColumn<>("Preferred Name");
		pnameColumn.setCellValueFactory(new PropertyValueFactory<>("preferredName"));
		
		TableColumn<User, String> middleNameColumn = new TableColumn<>("Middle Name");
		middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
		
		TableColumn<User, String> lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		TableColumn<User, String> emailColumn = new TableColumn<>("Email Address");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
		
		TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		
		TableColumn<User, String> roleColumn = new TableColumn<>("Roles");
		roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
		
		// Add columns to the table
		listView.getColumns().add(firstNameColumn);
		listView.getColumns().add(pnameColumn);
		listView.getColumns().add(middleNameColumn);
		listView.getColumns().add(lastNameColumn);
		listView.getColumns().add(emailColumn);
		listView.getColumns().add(usernameColumn);
		listView.getColumns().add(roleColumn);
		
		// Load data from csv
		loadDataFromCSV();
		
		// Button for Management menu
		Button mngMenu = new Button ("Account Management Menu");
		mngMenu.setOnAction(e -> {
			AdminMenu AdminMenu = new AdminMenu();
			AdminMenu.start(primaryStage);
			
		});
		
		// Button for article Management menu
		Button artMenu = new Button ("Article Management Menu");
		artMenu.setOnAction(e -> {
			ArticleMenuManagement artMenuMan = new ArticleMenuManagement();
		    artMenuMan.start(primaryStage);
							
		});
		
		
		// Button to logout
		Button logoutButton = new Button("Yes, logout of this account");
	    logoutButton.setOnAction(e -> {
	    	LogoutScreen logoutScrn = new LogoutScreen();
	    	logoutScrn.start(primaryStage);
	    });
	    
	    
	    // VBox used to hold everything on top of eachother
	    VBox vbox = new VBox(20);
	    vbox.setAlignment(Pos.CENTER);
	    vbox.getChildren().addAll(headingLabel, mngMenu, artMenu, listView, logoutButton);

		//showing stage & setting scene
	    Scene scene = new Scene(vbox, 500, 500);
	    primaryStage.setTitle("Accounts List");
        primaryStage.setScene(scene);
        primaryStage.show();
	    // list will go under hbox
	}
	
	
	// Method for loading data from csv
	private void loadDataFromCSV()
	{
		CSVfileHandler csvHandler = new CSVfileHandler("src/resources/csv_empty.csv");
		
		//read data
		List<String[]> usersData = csvHandler.readFromCSV();
		
		//debug statement
		System.out.println("test1");
		
		for (String[] userData : usersData)
		{
			//debug statement
			System.out.println("test2 for loop");
			if (userData.length >= 8)
			{
				//debug statement
				System.out.println("test3 if loop");
				
				String firstName = userData[0];
				String preferredName = userData[1];
				String middleName = userData[2];
				String lastName = userData[3];
				String emailAddress = userData[4];
				String username = userData[5];
				String password = (userData[6]);
				String role = userData[7];
				//debug statement
				System.out.println("test4 for loop");
				
				User user = new User(firstName, preferredName, middleName, lastName, emailAddress, username, password, role);
				//debug statement
				System.out.println("test5 for loop");
				
				listView.getItems().add(user);
			}
		}
	}
	//Used to test screen
	public static void main(String[] args) {
        launch(args);
    }
	
}