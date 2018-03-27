
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel ="stylesheet" type="text/css" href="css/style.css">
<!DOCTYPE html>
<html lang="en">

        <p><br/></p>
        <%
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
        %>
        <div class="everything">
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-6"><h3>Account Settings</h3></div>
                    <div class="col-md-6 text-right">
                        <a href="home" class="btn btn-info">Back to Home</a>
                    </div>
                </div>
                <p></p>
                <form action="" method="post">
                    <%
                    statement = connection.createStatement();
                    String uum = request.getParameter("u");
                    System.out.println(uum);
                    String Data = "select * from Users361 where userName = '"+uum;
                    rs = statement.executeQuery(Data);
                    while (rs.next()) {
                    %>   
                    
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fName" name="fn" value='<%=rs.getString(1)%>'>
                    </div>
                    <div class="form-group">
                        <label for="Class">Email</label>
                        <input type="text" class="form-control" id="email" name="em" value='<%=rs.getString(2)%>'>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="text" class="form-control" id="pw" name="pa" value='<%=rs.getString(4)%>'>
                    </div>
                    <%   
                    }
                    %>
                    <button type="submit" class="btn btn-warning">Update</button>
                </form>
            </div>
        </div>
</html>
<%
String fullName=request.getParameter("fn");
String email=request.getParameter("em");
String password=request.getParameter("pa");

int updateQuery = 0;
if(fullName!=null && email!=null && password!=null){
    try{
        String query="update Users361 set fullName =?,email =?,password=? where userName='"+uum;
        ps=connection.prepareStatement(query);
        ps.setString(1,fullName);
        ps.setString(2,email);
        ps.setString(4,password);
        updateQuery=ps.executeUpdate();
        if(updateQuery!=0){
            response.sendRedirect("home");
        }
    }catch(Exception ex){
        out.println("Your Connection: "+ex);
    }finally{
        ps.close();
        connection.close();
    }
}
%>