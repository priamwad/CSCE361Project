<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel ="stylesheet" type="text/css" href="css/style.css">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>Insert title here</title>
</head>


<body >
<div class ="everything">
<h1>Home Page</h1>
<p>Recent Notes </p>
<form  action ="notes.jsp">
		<input type= "submit" value= "Add a Note"> </input>
		</form>
<table border= "0" cellpadding="15" width="800">
	<tr>
		<td>Note Title</td>
		<td>Note Class</td>
		<td>Note Date</td> 
		<td>Note Content </td>
		<td>Edit Note</td>
		<td>Delete Note</td>
	</tr>
	<tr>
	<c:forEach var="nb" items = "${nbList}">
		<c:set var= "new" value="<br />" />
	    <td>${nb.noteTitle}</td> 
		<td>${nb.noteClass} </td>
		<td> ${nb.noteDate} </td>
		<td>${nb.noteContent}</td>

		<td> <form action ="EditServlet">
		<input type= "submit" value= "EditServlet"> </input>
		</form></td>
	   <td> <form action ="Remove.jsp">
		<input type= "submit" value= "Remove"> </input>
		<br>
		</form></td>
	</tr>
	<%= '\n' %>
	</c:forEach>

	</table>
	</div>
</body>
</html>