
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel ="stylesheet" type="text/css" href="css/style.css">
<!DOCTYPE html>
<html lang="en">


		<%String userName = (String) request.getAttribute("ub");
		String userName2 = (String) request.getAttribute("ub2"); 
		%>
				
        <p><br/></p>
        <div class="everything">
         <a position = "right" href="home" class="btn btn-primary">Home</a> 
         <a position = "right" href="accountSettings.jsp?u=<%=userName2%>'" class="btn btn-primary">Account Settings</a> 
           <a position = "right" href="loginPage.jsp" class="btn btn-primary">Logout</a>    
           
       
        <p></p>
        <table border= "0" cellpadding="15" width="800">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Class</th>
                    <th>Date</th>
                    <th>Content</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
            	// JDBC driver name and database URL
            	
            	String DB_URL = "jdbc:mysql://cse.unl.edu:3306/ppoudel";
            	//  Database credentials
            	String USER = "ppoudel"; 
            	String PASS = "9cB73r";   
                
                Connection connection = null;
                Statement statement = null;
                ResultSet rs = null;
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                statement = connection.createStatement();
                String Data = "select * from UsersNotes361";
                rs = statement.executeQuery(Data);
                while (rs.next()) {
                	if( rs.getString(2).equals(userName) || rs.getString(2).equals(userName2) ){
                %>
                <tr>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><%=rs.getString(5)%></td>
                    <td><%=rs.getString(6)%></td>
                      <td class="text-center" width="160">
                        <a href='edit.jsp?u=<%=rs.getString(1)%>' class="btn btn-warning">Edit</a>
                        <a href='delete?d=<%=rs.getString(3)%>' class="btn btn-danger">Delete</a>
                    </td>
                    </td>
                </tr>
                <%
                }}
                %>

            </tbody>
        </table> 
         <a href="notes.jsp" class="btn btn-primary">Add Note</a>
        </div>
</html>