<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%
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
<title>User HomePage</title>
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
			<li><a href="ShowDiagnosticCenterServlet">Make Appointment</a></li>
			<li><a href="CheckAppointmentStatusServlet">Check
					Appointment Status</a></li>
			<li><a href="LogoutServlet">Logout</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<footer>
	<p>sfzsgfhtgffffffffff</p>
	</footer>
</body>
</html>