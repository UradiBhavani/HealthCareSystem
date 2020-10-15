<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	<div class="container">
		<div id="branding">

			<h1 class="logo">HCS</h1>

		</div>
		<nav>
		<ul>
			<li><a href="AdminHomePage.jsp">Home</a></li>
			<li><a href="LogoutServlet">Logout</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<form action="CreateCenterServlet" method="post">
		<table>
			<tr>
				<td>Enter CenterName:</td>
				<td><input type="text" name="centerName"></td>
			</tr>
			<tr>
				<input type="submit" value="Create Center">
			</tr>
		</table>
	</form>
	<footer>
	<p>sfzsgfhtgffffffffff</p>
	</footer>
</body>
</html>