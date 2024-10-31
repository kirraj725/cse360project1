package com.yourdomain.cse360groupproject;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;

//import org.bouncycastle.util.Arrays;

import Encryption.EncryptionHelper;
import Encryption.EncryptionUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.FileReader;

class DatabaseHelper {

	// JDBC driver name and database URL 
	static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:~/firstDatabase";  

	//  Database credentials 
	static final String USER = "sa"; 
	static final String PASS = ""; 
	
	// Database connection
	private Connection connection = null;
	private Statement statement = null; 
	
	// Encryption
	private EncryptionHelper encryptionHelper;
	
	// Default constructor
	public DatabaseHelper() throws Exception {
		encryptionHelper = new EncryptionHelper();
	}

	// Connect to the database
	public void connectToDatabase() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER); // Load the JDBC driver
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS); // Get connection based on credentials
			statement = connection.createStatement(); 
			createTables();  // Create the necessary tables if they don't exist
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
		}
	}

	
	// Create tables in database
	private void createTables() throws SQLException {
		String articlesTable = "CREATE TABLE IF NOT EXISTS articles ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "header VARCHAR(255) NOT NULL, "
                + "title VARCHAR(255) NOT NULL, "
                + "description TEXT, "
                + "keywords VARCHAR(255), "
                + "body TEXT NOT NULL, "
                + "references TEXT)"
        		+ "misc TEXT, ";

		statement.execute(articlesTable);
	}


	// Check if the database is empty
	public boolean isDatabaseEmpty() throws SQLException {
		String query = "SELECT COUNT(*) AS count FROM articles";
		ResultSet resultSet = statement.executeQuery(query);
		if (resultSet.next()) {
		    return resultSet.getInt("count") == 0;
		}
		return true;
	}

	// Store article in database
	public void storeArticle(String header, String title, String description, String keywords, String body, String references, String misc) throws Exception {

		// Encrypting parameters using Base64 encoding after encryption
		//String encryptedAuthors = Base64.getEncoder().encodeToString(encryptionHelper.encrypt(authors.getBytes(), EncryptionUtils.getInitializationVector(title.toCharArray())));
		
		String encryptedDescription = Base64.getEncoder().encodeToString(encryptionHelper.encrypt(description.getBytes(), EncryptionUtils.getInitializationVector(title.toCharArray())));
		
		String encryptedKeywords = Base64.getEncoder().encodeToString(encryptionHelper.encrypt(keywords.getBytes(), EncryptionUtils.getInitializationVector(title.toCharArray())));
		
		String encryptedBody = Base64.getEncoder().encodeToString(encryptionHelper.encrypt(body.getBytes(), EncryptionUtils.getInitializationVector(title.toCharArray())));
		
		String encryptedReferences = Base64.getEncoder().encodeToString(encryptionHelper.encrypt(references.getBytes(), EncryptionUtils.getInitializationVector(title.toCharArray())));
		
		// SQL query to insert the article into the articles table
		String insertArticle = "INSERT INTO articles (header, title, description, keywords, body, references, misc) "
		            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		// Insert new article in database
		try (PreparedStatement pstmt = connection.prepareStatement(insertArticle)) {
			pstmt.setString(1, header);  // header is not encrypted
			//pstmt.setString(2, encryptedAuthors);
			pstmt.setString(2,  title);
			pstmt.setString(3, encryptedDescription);
			pstmt.setString(4, encryptedKeywords);
			pstmt.setString(5, encryptedBody);
			pstmt.setString(6, encryptedReferences);
			pstmt.setString(7, misc);
			pstmt.executeUpdate();
		}
	}


	// Check if article already exists
	public boolean doesArticleExist(String title) {
		String query = "SELECT COUNT(*) FROM articles WHERE title = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(query)) {
		    
		    pstmt.setString(1, title);  // Setting the title parameter
		    ResultSet rs = pstmt.executeQuery();
		    
		    if (rs.next()) {
		        // If the count is greater than 0, the article with the given title exists
		        return rs.getInt(1) > 0;
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return false; // If an error occurs, assume the article doesn't exist

	}

	// Delete article from database by id/sequence number
	public void deleteArticleById(int id) throws Exception {
	    String sql = "DELETE FROM articles WHERE id = ?";

	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setInt(1, id);  // Set the article ID

	        int rowsAffected = pstmt.executeUpdate();  // Execute the delete query

	        // Display the result
	        if (rowsAffected > 0) {
	            System.out.println("Article with ID " + id + " was deleted successfully.");
	        } else {
	            System.out.println("No article found with ID " + id + ".");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error deleting article: " + e.getMessage());
	        throw e;  // Rethrow exception for further handling if needed
	    }
	} 

	
	// List all articles in the database
	public void displayAllArticles() throws Exception {
	    String sql = "SELECT * FROM articles";
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);

	    while (rs.next()) {
	        // Retrieve by column name
	        int id = rs.getInt("id");
	        String title = rs.getString("title");  // Title stays as String since it's not encrypted

	        /*
	        // Decrypt authors
	        String encryptedAuthors = rs.getString("authors");
	        char[] decryptedAuthors = EncryptionUtils.toCharArray(
	            encryptionHelper.decrypt(
	                Base64.getDecoder().decode(encryptedAuthors),
	                EncryptionUtils.getInitializationVector(title.toCharArray())
	            )
	        );
	        */

	        // Decrypt abstract
	        String encryptedDescription = rs.getString("description");
	        char[] decryptedDescription = EncryptionUtils.toCharArray(
	            encryptionHelper.decrypt(
	                Base64.getDecoder().decode(encryptedDescription),
	                EncryptionUtils.getInitializationVector(title.toCharArray())
	            )
	        );

	        // Decrypt keywords
	        String encryptedKeywords = rs.getString("keywords");
	        char[] decryptedKeywords = EncryptionUtils.toCharArray(
	            encryptionHelper.decrypt(
	                Base64.getDecoder().decode(encryptedKeywords),
	                EncryptionUtils.getInitializationVector(title.toCharArray())
	            )
	        );

	        // Decrypt body
	        String encryptedBody = rs.getString("body");
	        char[] decryptedBody = EncryptionUtils.toCharArray(
	            encryptionHelper.decrypt(
	                Base64.getDecoder().decode(encryptedBody),
	                EncryptionUtils.getInitializationVector(title.toCharArray())
	            )
	        );

	        // Decrypt references
	        String encryptedReferences = rs.getString("references");
	        char[] decryptedReferences = EncryptionUtils.toCharArray(
	            encryptionHelper.decrypt(
	                Base64.getDecoder().decode(encryptedReferences),
	                EncryptionUtils.getInitializationVector(title.toCharArray())
	            )
	        );

	        // Display encrypted and decrypted values
	        System.out.println("ID: " + id);
	        System.out.println("Title: " + title);

	        System.out.println("Authors: ");
	        System.out.print(encryptedDescription + "\n");
	        EncryptionUtils.printCharArray(decryptedDescription);
	        System.out.println("\n");
	        
	        /*
	        System.out.println("Abstract: ");
	        System.out.print(encryptedAbstract + "\n");
	        EncryptionUtils.printCharArray(decryptedAbstract);
	        System.out.println("\n");
	        */
	        

	        System.out.println("Keywords: ");
	        System.out.print(encryptedKeywords + "\n");
	        EncryptionUtils.printCharArray(decryptedKeywords);
	        System.out.println("\n");
	        

	        System.out.println("Body: ");
	        System.out.print(encryptedBody + "\n");
	        EncryptionUtils.printCharArray(decryptedBody);
	        System.out.println("\n");

	        System.out.println("References: ");
	        System.out.print(encryptedReferences + "\n");
	        EncryptionUtils.printCharArray(decryptedReferences);
	        System.out.println("\n");
	        

	        // Clear the char arrays after use for security
	        //Arrays.fill(decryptedAuthors, '0');
	        Arrays.fill(decryptedDescription, '0');
	        Arrays.fill(decryptedKeywords, '0');
	        Arrays.fill(decryptedBody, '0');
	        Arrays.fill(decryptedReferences, '0');
	    }
	}
	
	// Back up database to operator-specified file name
	public void writeArticlesToFile(String fileName) throws Exception {
	    String sql = "SELECT * FROM articles";
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        // Write headers to the file
	        writer.write("ID,Header,Title,Description,Keywords,Body,References, Misc");
	        writer.newLine();

	        // Iterate through the database and write data to the file
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String header = rs.getString("header");
	            //String encryptedAuthors = rs.getString("authors");
	            String encryptedDescription = rs.getString("description");
	            String encryptedKeywords = rs.getString("keywords");
	            String encryptedBody = rs.getString("body");
	            String encryptedReferences = rs.getString("references");
	            String misc = rs.getString("misc");

	            // Decrypt the encrypted fields
	            /*
	            char[] decryptedAuthors = EncryptionUtils.toCharArray(
	                encryptionHelper.decrypt(
	                    Base64.getDecoder().decode(encryptedAuthors),
	                    EncryptionUtils.getInitializationVector(title.toCharArray())
	                )
	            );
	            */
	            char[] decryptedDescription = EncryptionUtils.toCharArray(
	                encryptionHelper.decrypt(
	                    Base64.getDecoder().decode(encryptedDescription),
	                    EncryptionUtils.getInitializationVector(title.toCharArray())
	                )
	            );
	            char[] decryptedKeywords = EncryptionUtils.toCharArray(
	                encryptionHelper.decrypt(
	                    Base64.getDecoder().decode(encryptedKeywords),
	                    EncryptionUtils.getInitializationVector(title.toCharArray())
	                )
	            );
	            char[] decryptedBody = EncryptionUtils.toCharArray(
	                encryptionHelper.decrypt(
	                    Base64.getDecoder().decode(encryptedBody),
	                    EncryptionUtils.getInitializationVector(title.toCharArray())
	                )
	            );
	            char[] decryptedReferences = EncryptionUtils.toCharArray(
	                encryptionHelper.decrypt(
	                    Base64.getDecoder().decode(encryptedReferences),
	                    EncryptionUtils.getInitializationVector(title.toCharArray())
	                )
	            );

	            // Write data to the file
	            writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s",
	                id,
	                header,
	                title,
	                //new String(decryptedAuthors),
	                new String(decryptedDescription),
	                new String(decryptedKeywords),
	                new String(decryptedBody),
	                new String(decryptedReferences),
	                misc
	            ));
	            writer.newLine();

	            // Clear sensitive data
	            //Arrays.fill(decryptedAuthors, '0');
	            Arrays.fill(decryptedDescription, '0');
	            Arrays.fill(decryptedKeywords, '0');
	            Arrays.fill(decryptedBody, '0');
	            Arrays.fill(decryptedReferences, '0');
	        }

	        System.out.println("Articles have been successfully written to the file: " + fileName);
	    } catch (IOException e) {
	        System.err.println("Error writing to file: " + e.getMessage());
	    } finally {
	        rs.close();  // Ensure the ResultSet is closed
	        stmt.close(); // Ensure the Statement is closed
	    }
	}
	
	// Restore data from operator-specified file name to the database
	public void restoreArticlesFromFile(String filePath) throws Exception {
	    // Reset the database by deleting existing articles
		resetArticles();

	    String sql = "INSERT INTO articles (title, authors, abstract, keywords, body, references) VALUES (?, ?, ?, ?, ?, ?)";
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
	         PreparedStatement pstmt = connection.prepareStatement(sql)) {

	        String line;
	        // Skip the header line
	        reader.readLine();

	        // Read each line from the file
	        while ((line = reader.readLine()) != null) {
	            String[] fields = line.split(",", -1); // -1 to include empty fields

	            // Ensure the fields are as expected
	            if (fields.length < 7) { // Expecting 7 fields (ID, Title, Authors, Abstract, Keywords, Body, References)
	                System.err.println("Invalid data format: " + line);
	                continue; // Skip this line if it's not valid
	            }

	            // Set the parameters for the prepared statement
	            pstmt.setString(1, fields[1]); // Title 
	            pstmt.setString(2, Base64.getEncoder().encodeToString(
	                encryptionHelper.encrypt(fields[2].getBytes(), EncryptionUtils.getInitializationVector(fields[1].toCharArray())))); // Authors (encrypted)
	            pstmt.setString(3, Base64.getEncoder().encodeToString(
	                encryptionHelper.encrypt(fields[3].getBytes(), EncryptionUtils.getInitializationVector(fields[1].toCharArray())))); // Abstract (encrypted)
	            pstmt.setString(4, Base64.getEncoder().encodeToString(
	                encryptionHelper.encrypt(fields[4].getBytes(), EncryptionUtils.getInitializationVector(fields[1].toCharArray())))); // Keywords (encrypted)
	            pstmt.setString(5, Base64.getEncoder().encodeToString(
	                encryptionHelper.encrypt(fields[5].getBytes(), EncryptionUtils.getInitializationVector(fields[1].toCharArray())))); // Body (encrypted)
	            pstmt.setString(6, Base64.getEncoder().encodeToString(
	                encryptionHelper.encrypt(fields[6].getBytes(), EncryptionUtils.getInitializationVector(fields[1].toCharArray())))); // References (encrypted)

	            // Execute the insert
	            pstmt.executeUpdate();
	        }

	        System.out.println("Articles have been successfully restored from the file: " + filePath);
	    } catch (IOException e) {
	        System.err.println("Error reading from file: " + e.getMessage());
	    } catch (SQLException e) {
	        System.err.println("Error inserting articles into the database: " + e.getMessage());
	    }
	}
	
	// Reset articles in the database
	private void resetArticles() throws SQLException {
		// Delete all articles
	    String deleteSql = "DELETE FROM articles";
	    try (PreparedStatement deletePstmt = connection.prepareStatement(deleteSql)) {
	        deletePstmt.executeUpdate();
	    }

	    // Reset the auto-increment value
	    String resetSql = "ALTER TABLE articles ALTER COLUMN id RESTART WITH 1"; // Resets ID to start from 1
	    try (PreparedStatement resetPstmt = connection.prepareStatement(resetSql)) {
	        resetPstmt.executeUpdate();
	    }
	}



	// Close database connection
	public void closeConnection() {
		try{ 
			if(statement!=null) statement.close(); 
		} catch(SQLException se2) { 
			se2.printStackTrace();
		} 
		try { 
			if(connection!=null) connection.close(); 
		} catch(SQLException se){ 
			se.printStackTrace(); 
		} 
	}

}
