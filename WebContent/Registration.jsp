<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--  <%
if (session.getAttribute("userId") == null) {
	response.sendRedirect("index.jsp");
}

else {
	if (session.getAttribute("role").equals("usr")) {
		response.sendRedirect("UserHomePage.jsp");
	}
	if (session.getAttribute("role").equals("adm")) {
		response.sendRedirect("AdminHomePage.jsp");
	}
}
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type " text/css" href="LoginRegister.css">
</head>
<body>

	<header id="header">
	<div class="container">
		<div id="branding">
				<!--<h1><span class = "highlight">ONE</span> STOP DOCS</h1>-->
				<!-- <h1 class="logo">HCS</h1> -->
				<!--<img src="logo-1.png" class="img" alt="logo">-->
				<div class="logo-image">
					<img src="images/logo.png" style="width:30%;height:90%;"></img>
					</div>
			</div>
		<nav>
		<ul>
			<li class="current"><a href="index.jsp">Home</a></li>
			<li><a href="Login.jsp">Login</a></li>
		</ul>
		</nav>
	</div>
	</header>

	<div class="box">
		<h1>User Registration</h1>
		<form action="RegisterServlet" method="post">
			<table>
				<!-- <tr>
				<td>UserId</td>
				<td><input type="text" id="userid" name="userid" value="" read only></td>
			</tr> -->
				<tr>
					<td>UserName</td>
					<td>:</td>
					<td><input type="text" id="username" name="username"></td>

				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" id="password" name="password"
						pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$"></td>
				</tr>
				<tr>
					<td>Contact no</td>
					<td>:</td>
					<td><input type="tel" id="contactno" name="contactno"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" id="email" name="email"></td>
				</tr>
			</table>
			<br>
			<center>
				<input type="submit" name="s" value="Register">
			</center>
		</form>
	</div>
	<footer>
	<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>
</body>
</html>





