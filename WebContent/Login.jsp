<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	if (session.getAttribute("userId") != null && session.getAttribute("role") != null) {

		if (session.getAttribute("role").equals("usr")) {

			response.sendRedirect("UserHomePage.jsp");
		} else {
			response.sendRedirect("AdminHomePage.jsp");
		} 
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="LoginRegister.css">

</head>
<body>

	<header id="header">
		<div class="container">
			<div id="branding">

				<h1 class="logo">HCS</h1>

			</div>
			<nav>
				<ul>
					<li class="current"><a href="index.jsp">Home</a></li>
				</ul>
			</nav>
		</div>
	</header>


	<div class="box">
		<h1>Login</h1>
		<form action="LoginServlet" method="post">
			<br>
			<table>
				<tr>
					<td>UserId</td>
					<td>:</td>
					<td><input type="text" name="userid"></input></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></input></td>
				</tr>
			</table>
			<center>
				<input type="submit" name="s" value="submit">
			</center>
		</form>
	</div>

	<footer>
		<p>sfzsgfhtgffffffffff</p>
	</footer>
</body>
</html>