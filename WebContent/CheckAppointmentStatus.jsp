<%@page import="com.cg.hcs.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<center><table border="4">
		<tr>
			<th>CenterName
			<th>TestName
			<th>AppointmentDate & time
			<th>Status
			
		</tr>
		<%
			List<Appointment> appointmentList = (List<Appointment>) request.getAttribute("appointmentList");
			for (Appointment appointment : appointmentList) {
		%>
		<tr>
			<td><%=appointment.getCenter().getCenterName() %>
			<td><%=appointment.getTest().getTestName() %>
			<td><%=appointment.getAppDate() %>
			<%
				String status="";
				if(appointment.getIsApproved()=='P'){
					status="Pending";
				} else if(appointment.getIsApproved()=='A'){
					status="Approved";
				}else{
					status="Rejected";
				}
			%>
			<td><%=status%>
		</tr>
		<%
			}
		%>

	</table></center>
	<footer>
	<p>sfzsgfhtgffffffffff</p>
	</footer>
</body>
</html>