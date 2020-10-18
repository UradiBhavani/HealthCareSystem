<%@page import="com.cg.hcs.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.hcs.service.AdminServiceImpl"%>
<%@page import="com.cg.hcs.service.IAdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Reject Appointment</title>
</head>
<link rel="stylesheet" type " text/css" href="LoginRegister.css">
<link rel="stylesheet" type " text/css" href="css/showCenters.css">
<body>

	<%
		IAdminService adminService = new AdminServiceImpl();
			String centerId = request.getParameter("centerId");
			List<Appointment> appointmentList = adminService.viewAllAppointmentsByCenter(centerId);
			if(appointmentList.isEmpty())
			{
		out.println("<h1>No Appointments Yet</h1>");
			}
			else
			{
	%>
	<div class="table-div">
		<table border="4" ,class="table-style" cellpadding="15%">
		<tr class="table-heading">
			<th>Appointment Id
			<th>Test Name
			<th>Center Name
			<th>Appointment Date Time
			<th>User Id
			<th>Status
			<th colspan="2">Approve/Reject Appointment
		</tr>
		<%
			for(Appointment appointment : appointmentList)
			{
				int appId = appointment.getAppId();
				if(appointment.getAppStatus()=='P')
				{
				%>
				<tr class="table-row">
					<td><%=appId%>
					<td><%=appointment.getTest().getTestName() %>
					<td><%=appointment.getCenter().getCenterName()%>
					<td><%=appointment.getAppDate()%>
					<td><%=appointment.getUser().getUserId() %>
					<td>Pending
					<td><a href="ChangeAppointmentStatusServlet?appId=<%=appId%>&appStatus=A"><button>Approve</button></a>
					<td><a href="ChangeAppointmentStatusServlet?appId=<%=appId%>&appStatus=R"><button>Reject</button></a>
				</tr>
				<%}
			  }
			for(Appointment appointment : appointmentList)
			{
				int appId = appointment.getAppId();
				if(appointment.getAppStatus()!='P')
				{
		%>
		<tr class="table-row">
					<td><%=appId%>
					<td><%=appointment.getTest().getTestName() %>
					<td><%=appointment.getCenter().getCenterName()%>
					<td><%=appointment.getAppDate()%>
					<td><%=appointment.getUser().getUserId() %>4
					<%if(appointment.getAppStatus()=='A')
						{%>
					<td>Approved
					<%}else
						{%>
						<td>Rejected
						<%} %>	
					<td><button disabled="disabled">Approve</button></a>
					<td><button disabled="disabled">Reject</button></a>
				</tr>
		<%}
				}%>
			</table>
			</div>
		<%} %>
</body>
</html>