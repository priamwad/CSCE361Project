package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class userDB {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/ppoudel";
	
	//  Database credentials
	static final String USER = "ppoudel"; 
	static final String PASS = "9cB73r";   
	
//--------------------------------- Create User Table-------------------------------	
	public void createUsers361() {
		  
		try {
		  stmt = conn.createStatement();
		
		  String sql;
		  sql = "DROP TABLE IF EXISTS Users361";
		  stmt.executeUpdate(sql);

		  sql = "CREATE TABLE Users361 " +
		          "("+
		          " fullName VARCHAR(15), " + 
		          " email VARCHAR(25), "+
		          " userName VARCHAR(15), " +
		          " password VARCHAR(15), " +
		          "PRIMARY KEY(userName))"; 

		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	

// ------------------------------- Validating userName from the Database --------------------------
	public boolean checkIfUserExist(String userName)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		String SQL = "SELECT * from Users361";
	    Statement stat;
	    boolean result = false;
	    
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(userName.equals(rs.getString("userName"))) {
					result = true;
				} 
		    }

		    stat.close();
			conn.close();		
		
		return result;
	}
// ------------------------------- Validating password from the Database --------------------------
	public boolean checkIfUserPasswordExist(String userName, String password)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		String SQL = "SELECT * from Users361";
	    Statement stat;
	    boolean result = false;
	    
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(userName.equals(rs.getString("userName")) && password.equals(rs.getString("password"))) {
					result = true;
				} 
		    }

		    stat.close();
			conn.close();		
		
		return result;
	}
// ------------------------------- Grab User from the Database --------------------------
	public userBean returnUserbyUserName(String userName)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		String SQL = "SELECT * from Users361";
	    Statement stat;
	    
	    String fullName = "";
	    String email = "";
	    String password = "";
	    
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(userName.equals(rs.getString("userName"))) {
					fullName = rs.getString("fullName");
					email = rs.getString("email");
					password = rs.getString("password");
				} 
		    }

		    stat.close();
			conn.close();
		
		userBean user = new userBean(fullName,email,userName,password);
		return user;
	}
// ------------------------------- Insert User to the Database --------------------------
	public void insertUserToTheDataBase(String userName, String password, String email, String fullName) 
			throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
		  stmt = conn.createStatement();
		  String sql;

		  sql = "INSERT INTO Users361 (fullName,email,userName,password)" +
		          "VALUES ('" + fullName +
				  "', '" + email + 
				  "', '" + userName + 
				  "', '" + password + 
				   "')";
		  stmt.executeUpdate(sql);
		  conn.close();
	}
}
