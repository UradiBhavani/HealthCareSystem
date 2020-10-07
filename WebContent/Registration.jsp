<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		<table>
			<!-- <tr>
				<td>UserId</td>
				<td><input type="text" id="userid" name="userid" value="" read only></td>
			</tr> -->
			<tr>
				<td>UserName</td>
				<td><input type="text" id="username" name="username"></td>
				
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$"></td>
			</tr>
			<tr>
				<td>Contact no</td>
				<td><input type="tel" id="contactno" name="contactno" ></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" id="email" name="email" ></td>
			</tr>
			<tr><input type="submit" name="Register"></tr>
			
		</table>
	</form>

</body>
</html>