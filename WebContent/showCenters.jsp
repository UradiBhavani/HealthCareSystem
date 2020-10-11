<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="MakeAppointmentServlet" method="get">
		Choose Center <select option="centersList" name="centerList" onchange="">
		<%
		   	ArrayList<String> centersList = (ArrayList<String>) request.getAttribute("centersList");
		   	for(String centerName:centersList){
		%>
		   	
		   		<option value=<%= centerName %>><%= centerName %></option>
		 
		<%
		   }
		%>
		   </select>
		  
		   
		   Date<input type="date" id="date" name="date">
		   Time<input type="time" id="appt" name="appt">
		   
		   
		<input type="submit" name="Book Appointment">
	</form>

</body>
</html>