<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel ="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<form name = userForm  
	action ="addNotesServlet" method ="post">
	
	Enter Note Title: <input type = "text" name="noteTitle"><br>
	Enter Note Class: <input type = "text"  name="noteClass"><br>
	Enter Note Date: <input type = "text" name="noteDate"><br>
	Enter Note Content: <input type = "text" name="noteContent"><br>
	<input type = "submit" value="Add Note"><br>
	
	</form>

</body>
</html>