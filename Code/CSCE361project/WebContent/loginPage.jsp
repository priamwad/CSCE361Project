<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel ="stylesheet" type="text/css" href="css/style.css">
<title>Login Page</title>
</head>
<body>
	<div class="wrapper"> 
	
	<form class = "form-signin" name = userForm  onsubmit="return validateForm()" 
	action ="loginServlet" method ="post">
	<h2 class="form-signin-heading">NOTE-ZILLA</h2>
	Enter your User Name: <input type= "text" name="userName" class = "form-control" ><br>
	Enter your Password: <input type = "text" name="password" class = "form-control" ><br>
	<button class="button arrow" type="submit">Login</button>  
	<a href= "registrationPage.jsp"> Click here if your a new user</a> 
	</form>

		<script>
			function validateForm() {
			    
				//grabbing data
				var userName = document.forms["userForm"]["userName"].value;
			    var password = document.forms["userForm"]["password"].value;
			   
			    //validating "" cases
			    if (userName == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    if (password == "") {
			        alert("Password must be filled out");
			        return false;
			    }			        
			}
	   </script>   
	   </div>
</body>
</html>