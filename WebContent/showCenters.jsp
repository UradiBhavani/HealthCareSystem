<%@page import="com.cg.hcs.entity.DiagnosticCenter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Centers</title>
<link rel="stylesheet" type " text/css" href="LoginRegister.css">
</head>
<body>

	<header id="header">
	<div class="container">
		<div id="branding">

			<h1 class="logo">HCS</h1>

		</div>
		<nav>
		<ul>
			<li><a href="UserHomePage.jsp">Home</a></li>
			<li><a href="LogoutServlet">Logout</a></li>
		</ul>
		</nav>
	</div>
	</header>

	<div class="box1">
		<div class="search-box">
			<table>
				<form action="searchByLocation" method="post">
					<tr>
						<td><input type="text" placeholder="Location" name="location"></td>
						<td><input type="submit" value="Search"></td>
					</tr>
				</form>
			</table>
		</div>


		<div class="show-centers">
			<center>
				<table border="4">
					<tr>
						<th>CenterName
						<th>Address
						<th>Contact No
						<th>Link
					</tr>
					<%
						ArrayList<DiagnosticCenter> centersList = (ArrayList<DiagnosticCenter>) request.getAttribute("centersList");
						for (DiagnosticCenter center : centersList) {
					%>
					<td><%=center.getCenterName()%></td>
					<td><%=center.getLocation()%></td>
					<td><%=center.getContactNo()%></td>
					<td><a
						href="makeAppointment.jsp?centerId=<%=center.getCenterId()%>&centerName=<%=center.getCenterName()%>">BookAppointment</a></td>


					<%
						}
					%>
				</table>
			</center>
		</div>
	</div>

	<footer>
	<p>sfzsgfhtgffffffffff</p>
	</footer>

</body>
</html>