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
<h1>
	Register An Account
</h1>
<h2>
	
</h2>
<body>
	<form name = userForm  onsubmit="return validateForm()" 
	action ="registrationServlet" method ="post">
	
	Enter your Full Name: <input type = "text" name="fullName"><br>
	Enter your Email: <input type = "text"  name="email"><br>
	Enter your User Name: <input type = "text" name="userName"><br>
	Enter your Password: <input type = "text" name="password"><br>
	Confirm your Password: <input type = "text" name="confirmPassword"><br>
	<input type = "submit" value="Register"><br>
	
	</form>
		<script>
			function validateForm() {
			    
				//grabbing data
				var userName = document.forms["userForm"]["userName"].value;
			    var password = document.forms["userForm"]["password"].value;
			    var fullName = document.forms["userForm"]["fullName"].value;
			    var email = document.forms["userForm"]["email"].value;
			    var confirmPassword = document.forms["userForm"]["confirmPassword"].value;
			   
			    //validating "" cases
			    if (fullName == "") {
			        alert("Full Name must be filled out");
			        return false;
			    }
			    if (email == "") {
			        alert("Email must be filled out");
			        return false;
			    }
			    if (userName == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    if (password == "") {
			        alert("Password must be filled out");
			        return false;
			    }
			    if (confirmPassword == "") {
			        alert(" Confirm Password must be filled out");
			        return false;
			    }
			    //validating passwords
			    if (confirmPassword != password) {
			        alert("Your passwords don't match");
			        return false;
			    }
			        
			}
	   </script>
</body>

</html>