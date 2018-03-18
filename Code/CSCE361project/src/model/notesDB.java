package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class notesDB {

	
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
	public void createUserNotes361() {
		  
		try {
		  stmt = conn.createStatement();
		
		  String sql;
		  sql = "DROP TABLE IF EXISTS UserNotes361";
		  stmt.executeUpdate(sql);

		  sql = "CREATE TABLE UsersNotes361 " +
		          "(notesID INT AUTO_INCREMENT"+
		          " userName VARCHAR(15), " + 
		          " noteTitle VARCHAR(25), "+
		          " noteClass VARCHAR(15), " +
		          " noteDate VARCHAR(15), " +
		          " noteContent VARCHAR(225), " +
		          "PRIMARY KEY(notesID))"; 

		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	
// ------------------------------- Grab notes from the Database --------------------------
	public ArrayList<notesBean> returnNotes(String userName)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		String SQL = "SELECT * from UsersNotes361";
	    Statement stat;
	    
	    String noteTitle = "";
	    String noteClass = "";
	    String noteDate = "";
	    String noteContent = "";
	    ArrayList<notesBean> nbList = new ArrayList<notesBean>();
			
	    	stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			notesBean NB = null;
			while (rs.next()){
				if(userName.equals(rs.getString("userName"))) {
					noteTitle = rs.getString("noteTitle");
					noteClass = rs.getString("noteClass");
					noteDate = rs.getString("noteDate");
					noteContent = rs.getString("noteContent");
				 NB = new notesBean(userName,noteTitle,noteClass,noteDate,noteContent);
				 nbList.add(NB);
				} 
		    }

		    stat.close();
			conn.close();
		return nbList;
	}
// ------------------------------- Insert User to the Database --------------------------
	public void insertNoteToTheDataBase(String userName, String title, String noteClass, String date, String content) 
			throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");			
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
		  stmt = conn.createStatement();
		  String sql;

		  sql = "INSERT INTO UsersNotes361 (userName,noteTitle,noteClass,noteDate,noteContent)" +
		          "VALUES ('" + userName +
				  "', '" + title + 
				  "', '" + noteClass + 
				  "', '" + date + 
				  "', '" + content + 
				   "')";
		  stmt.executeUpdate(sql);
		  conn.close();
	}
// ------------------------------- Checking is the user has any notes --------------------------
	public boolean doesTheUserHaveAnyNotes(String userName)throws Exception {
			
		boolean result = false;
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String SQL = "SELECT * from UsersNotes361";
		    Statement stat;
				
		    	stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(SQL);
				notesBean NB = null;
				while (rs.next()){
					if(userName.equals(rs.getString("userName"))) {
						result = true;
					} 
			    }

			    stat.close();
				conn.close();
			return result;
		}
}

