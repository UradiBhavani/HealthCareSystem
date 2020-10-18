<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="LoginRegister.css">
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
				</ul>
			</nav>
		</div>
	</header>

<div class="box">
	<form action="AddTestServlet" method="post">
		<table>
		<tr><td>Center Id: <td><input type="text" name="centerId" value=<%=request.getParameter("centerId") %> readonly>
		<tr><td>Test Name : <td><input type="text" name="testName" placeholder="Test Name">
		<tr><td><td><input type="submit" value="Add Test">
		</table>
	</form>
	</div>
</body>	
	
	<footer>
		<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>

</html>