
<%@page import="com.cg.hcs.entity.Test"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.hcs.service.UserServiceImpl"%>
<%@page import="com.cg.hcs.service.IUserService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Appointment</title>
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
			<li class="current"><a href="UserHomePage.jsp">Home</a></li>
			<li><a href="LogoutServlet">Logout</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<%
		IUserService userService = new UserServiceImpl();
		String id = request.getParameter("centerId");
		List<Test> testList = userService.getTestsList(id);
		System.out.println("In Makeappointment.jsp\n" + id + " " + request.getParameter("centerName"));
	%>
	<div class="box1">
		<form action="MakeAppointmentServlet" method="post">
			<%
				session.setAttribute("centerId", id);
			%>
			<table>
				<tr>
					<td>Selected Center</td>
					<td><input type="text"
						value=<%=request.getParameter("centerName")%> readonly></td>
				</tr>

				<tr>
					<td>Choose Test
					<td><select option="testList" id="testObj" name="testObj">
							<%
								for (Test test : testList) {
									System.out.println("Test id : " + test.getTestId());
							%>

							<option value=<%=test.getTestId()%>><%=test.getTestName()%></option>

							<%
								}
							%>
					</select></td>
				<tr>
					<td>Date</td>
					<td><input type="date" id="date" name="date"></td>
				</tr>
				<tr>
					<td>Time</td>
					<td><input type="time" id="appt" name="appt"></td>
				</tr>

			</table>
			<input type="submit" name="Book Appointment">
		</form>
	</div>
	<footer>
	<p>sfzsgfhtgffffffffff</p>
	</footer>
</body>
</html>