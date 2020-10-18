<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type " text/css" href="LoginRegister.css">
<link rel="stylesheet" type " text/css" href="css/showCenters.css">
</head>
<body>
	<header id="header">
	<div class="container">
		<div id="branding">
			<!--<h1><span class = "highlight">ONE</span> STOP DOCS</h1>-->
			<!-- <h1 class="logo">HCS</h1> -->
			<!--<img src="logo-1.png" class="img" alt="logo">-->
			<div class="logo-image">
				<img src="images/logo.png" style="width: 30%; height: 90%;"></img>
			</div>
		</div>
		<nav>
		<ul>
			<li><a href="AdminHomePage.jsp">Home</a></li>
			<li><a href="LogoutServlet">Logout</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<div class="box">
		<form action="CreateCenterServlet" method="post">
			<table>
				<tr class="">
					<td>Center Name :
					<td><input type="text" name="centerName">
				<tr>
					<td>Center Address
					<td><textarea name="centerAddress"
							placeholder="Center Address"></textarea>
				<tr>
					<td>Contact Number:
					<td><input type="tel" name="contactNumber">
				<tr>
					<td>
					<td><input type="submit" value="Create Center">
			</table>
		</form>
	</div>
	<footer>
	<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>
</body>
</html>