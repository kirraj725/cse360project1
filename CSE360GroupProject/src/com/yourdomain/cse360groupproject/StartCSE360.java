package simpleDatabase;

import java.sql.SQLException;
import java.util.Scanner;

public class StartCSE360 {

	// Database and scanner objects
	private static DatabaseHelper databaseHelper;
	private static final Scanner scanner = new Scanner(System.in);

	public static void main( String[] args ) throws Exception
	{
		databaseHelper = new DatabaseHelper();
		try { 
			
			databaseHelper.connectToDatabase();  // Connect to the database

			// Check if the database is empty (no users registered)
			if (databaseHelper.isDatabaseEmpty()) {
				System.out.println( "In-Memory Database  is empty" );
				// Set up help system
				setupHelpSystem();
			}
			else {
				// Prompt help system actions
				userFlow();
			}
		} catch (SQLException e) {
			// Database error
			System.err.println("Database error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("Good Bye!!");
			databaseHelper.closeConnection();
		}
	}

	// Set up help system when the database is empty
	private static void setupHelpSystem() throws Exception {
		System.out.println("Setting up the Help System.");
		
		// Collect article information from user
		System.out.print("Enter Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter Authors or List of Authors: ");
		String authors = scanner.nextLine();
		System.out.print("Enter the Abstract: ");
		String theAbstract = scanner.nextLine();
		System.out.print("Enter the Set of Keywords: ");
		String keywords = scanner.nextLine();
		System.out.print("Enter the Body of the Article: ");
		String body = scanner.nextLine();
		System.out.print("Enter the Set of References: ");
		String references = scanner.nextLine();
		
		databaseHelper.storeArticle(title, authors, theAbstract, keywords, body, references); // Store article information in database
		System.out.println("Help System setup completed.");

	}

	// Prompt help system actions
	private static void userFlow() throws Exception {
		System.out.println("user flow");
		System.out.print("What would you like to do 1.Create new article 2.Delete an article 3.List all articles 4.Back up articles 5.Restore articles");
		String choice = scanner.nextLine();
		
		// Perform help systme action based on user's choise
		switch(choice) {
		// Create new article
		case "1": 
			// Collect article information from user
			System.out.print("Enter Title: ");
			String title = scanner.nextLine();
			System.out.print("Enter Authors or List of Authors: ");
			String authors = scanner.nextLine();
			System.out.print("Enter the Abstract: ");
			String theAbstract = scanner.nextLine();
			System.out.print("Enter the Set of Keywords: ");
			String keywords = scanner.nextLine();
			System.out.print("Enter the Body of the Article: ");
			String body = scanner.nextLine();
			System.out.print("Enter the Set of References: ");
			String references = scanner.nextLine(); 
			// Check if user already exists in the database
		    if (!databaseHelper.doesArticleExist(title)) {
		        databaseHelper.storeArticle(title, authors, theAbstract, keywords, body, references); // Store article in database
		        System.out.println("Article creation completed.");
		    } else {
		        System.out.println("Article already exists.");
		    }
			break;
		// Delete article from the database by id/sequence numebr
		case "2":
			System.out.print("Article's sequence/id number: ");
			int id = scanner.nextInt();
			databaseHelper.deleteArticleById(id);
			break;
		// List all articles in the database
		case "3":
			databaseHelper.displayAllArticles();
			break;
		// Back up articles to operator-specified file name
		case "4":
			System.out.print("Enter file name: ");
			String fileName = scanner.nextLine();
			databaseHelper.writeArticlesToFile(fileName);
			break;
		// Restore articles from operator-specified file name to the database
		case "5":
			System.out.print("Enter file name: ");
			String file = scanner.nextLine();
			databaseHelper.restoreArticlesFromFile(file);
			break;
		}
	}


}
