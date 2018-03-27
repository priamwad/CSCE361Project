package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class editNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public editNotesServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
		String a=request.getParameter("nt");
		String b=request.getParameter("nm");
		String c=request.getParameter("em");
		String d=request.getParameter("pn");
		String e=request.getParameter("ad");
		
		int updateQuery = 0;
		if(a!=null && b!=null && c!=null && d!=null && e!=null){
		    try{
		    	 String DB_URL = "jdbc:mysql://cse.unl.edu:3306/ppoudel";
		     	//  Database credentials
		     	String USER = "ppoudel"; 
		     	String PASS = "9cB73r";   
		      
		         Connection connection = null;
		         Statement statement = null;
		         ResultSet rs = null;
		         PreparedStatement ps=null;
		         Class.forName("com.mysql.jdbc.Driver").newInstance();
		         connection = DriverManager.getConnection(DB_URL, USER, PASS);
		       
		         String query="update UsersNotes361 set name=?,email=?,phone=?,address=? where id='"+a+"'";
		        ps=connection.prepareStatement(query);
		        ps.setString(1,b);
		        ps.setString(2,c);
		        ps.setString(3,d);
		        ps.setString(4,e);
		        updateQuery=ps.executeUpdate();
		        if(updateQuery!=0){
		            response.sendRedirect("index.jsp");
		        }
		        ps.close();
		        connection.close();
		    }catch(Exception ex){
		        
		    }
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
