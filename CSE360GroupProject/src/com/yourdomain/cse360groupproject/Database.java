package com.yourdomain.cse360groupproject;

import java.sql.*;

public class Database {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/cse360database";
    
    //  Database credentials
    static final String USER = "sa"; 
    static final String PASS = ""; 

    private Connection connection = null;
    private Statement statement = null;

    public void connectToDatabase() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER); // Load the JDBC driver
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement(); 
            createTables();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
    }
    
    // Check if the database is empty
 	public boolean isDatabaseEmpty() throws SQLException {
 		String query = "SELECT COUNT(*) AS count FROM cse360users";
 		ResultSet resultSet = statement.executeQuery(query);
 		if (resultSet.next()) {
 			return resultSet.getInt("count") == 0;
 		}
 		return true;
 	}

    private void createTables() throws SQLException {
        String userTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "emailAddress VARCHAR(255) UNIQUE, "
                + "password VARCHAR(255), "
                + "role VARCHAR(20), "
                + "isNewUser BOOLEAN)";
        statement.execute(userTable);
    }

    public void registerUser(String firstName, String preferredName, String middleName, String lastName, String emailAddress, String username, int password, String role) throws SQLException {
        String insertUser = "INSERT INTO users (firstName, preferredName, middleName, lastName, email, username, password, role, isNewUser) VALUES (?, ?, ?, true)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertUser)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, preferredName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, emailAddress);
            pstmt.setString(6, username);
            pstmt.setString(7, String.valueOf(password));
            pstmt.setString(8, role);
            pstmt.executeUpdate();
        }
    }

    public boolean loginUser(String emailAddress, int password) throws SQLException {
        String query = "SELECT * FROM users WHERE emailAddress = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, emailAddress);
            pstmt.setString(2, String.valueOf(password));
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // return true if a match is found
        }
    }
    
    public boolean doesUserExist(String emailAddress) {
	    String query = "SELECT COUNT(*) FROM cse360users WHERE emailAddress = ?";
	    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	        
	        pstmt.setString(1, emailAddress);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            // If the count is greater than 0, the user exists
	            return rs.getInt(1) > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; // If an error occurs, assume user doesn't exist
	}
    
    public void displayUsersByAdmin() throws SQLException {
        String sql = "SELECT * FROM cse360users WHERE role = 'admin'";  // Filter by role
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
        	// Retrieve by column name 
        	String firstName =  rs.getString("firstName");
			String preferredName = rs.getString("preferredName");
			String middleName = rs.getString("middleName");
			String lastName =  rs.getString("lastName");
			String  emailAddress = rs.getString("email"); 
			int password  = rs.getInt("password");  
			String role = rs.getString("role");  

			// Display values 
			System.out.print("First Name: " + firstName); 
			System.out.print(", Last Name: " + lastName);
			System.out.print(", Preferred Name: " + preferredName);
			System.out.print(", Middle Name: " + middleName);
			System.out.print(", Email: " + emailAddress); 
			System.out.print(", First: " + password); 
			System.out.println(", Role: " + role);
        }
    }

    
    public void displayUsersByUser() throws SQLException{
		String sql = "SELECT * FROM cse360users"; 
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 

		while(rs.next()) { 
			// Retrieve by column name 
			String firstName =  rs.getString("firstName");
			String preferredName = rs.getString("preferredName");
			String middleName = rs.getString("middleName");
			String lastName =  rs.getString("lastName");
			String  emailAddress = rs.getString("email"); 
			int password  = rs.getInt("password");  
			String role = rs.getString("role");  

			// Display values 
			System.out.print("First Name: " + firstName); 
			System.out.print(", Last Name: " + lastName);
			System.out.print(", Preferred Name: " + preferredName);
			System.out.print(", Middle Name: " + middleName);
			System.out.print(", Email: " + emailAddress); 
			System.out.print(", First: " + password); 
			System.out.println(", Role: " + role); 
		} 
	}

    public void closeConnection() {
        try { if (statement != null) statement.close(); } 
        catch (SQLException se2) { se2.printStackTrace(); }
        try { if (connection != null) connection.close(); } 
        catch (SQLException se2) { se2.printStackTrace(); }
    }
}
