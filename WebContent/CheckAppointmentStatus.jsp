<%@page import="com.cg.hcs.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>CenterName<th>TestName<th>AppointmentDate & time<th>Status
		</tr>
		<%
			List<Appointment> appointmentList = (List<Appointment>)request.getAttribute("appointmentList");
			for(Appointment appointment:appointmentList){
		%>
		<tr>
			<td>appointment.getCenter()<td>appointment.getTest()<td>appointment.getAppDateTime()<td>td.getIsApproved()
			
		</tr>
		<%
			}
		%>
	
	</table>

</body>
</html>