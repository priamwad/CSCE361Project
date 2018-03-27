
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
                    <div class="col-md-6"><h3>Edit/Update Note</h3></div>
                    <div class="col-md-6 text-right">
                        <a href="home" class="btn btn-info">Back to Home</a>
                    </div>
                </div>
                <p></p>
                <form action="" method="post">
                    <%
                    statement = connection.createStatement();
                    String u=request.getParameter("u");
                    int num=Integer.parseInt(u);
                    String Data = "select * from UsersNotes361 where notesId='"+num+"'";
                    rs = statement.executeQuery(Data);
                    while (rs.next()) {
                    %>   
                    <input type="hidden" name="id" value='<%=rs.getInt(1)%>'/>
                    <div class="form-group">
                        <label for="Title">Title</label>
                        <input type="text" class="form-control" id="ntitle" name="nt" value='<%=rs.getString(3)%>'>
                    </div>
                    <div class="form-group">
                        <label for="Class">Class</label>
                        <input type="text" class="form-control" id="nClass" name="nc" value='<%=rs.getString(4)%>'>
                    </div>
                    <div class="form-group">
                        <label for="Date">Date</label>
                        <input type="tel" class="form-control" id="nDate" name="nd" value='<%=rs.getString(5)%>'>
                    </div>
                    <div class="form-group">
                        <label for="Content">Content</label>
                        <textarea class="form-control" id="nContent" name="ncon"><%=rs.getString(6)%></textarea>
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

String noteTitle=request.getParameter("nt");
String noteClass=request.getParameter("nc");
String noteDate=request.getParameter("nd");
String noteContent=request.getParameter("ncon");
int updateQuery = 0;
if(noteTitle!=null && noteClass!=null && noteDate!=null && noteContent!=null){
    try{
        String query="update UsersNotes361 set noteTitle=?,noteClass=?,noteDate=?,noteContent=? where notesID='"+num+"'";
        ps=connection.prepareStatement(query);
        ps.setString(1,noteTitle);
        ps.setString(2,noteClass);
        ps.setString(3,noteDate);
        ps.setString(4,noteContent);
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