<%@page import="com.cg.hcs.entity.DiagnosticCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.hcs.service.AdminServiceImpl"%>
<%@page import="com.cg.hcs.service.IAdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Centers</title>
<link rel="stylesheet" type " text/css" href="LoginRegister.css">
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
					<li><a href="AdminHomePage.jsp">Home</a></li>
					<li><a href="LogoutServlet">Logout</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="box">
		<table border="4" ,class="table-style" cellpadding="15%">
			<tr class="table-heading">
				<th>Center Id
				<th>Center Name
				<th>Center Address
				<th>Center Contact No
				<th colspan="2">Test
				<th>Approve Appointment
				<th>Center
			</tr>
			<%
				IAdminService adminService = new AdminServiceImpl();
				List<DiagnosticCenter> diagnosticCenters = adminService.viewAllCenters();
				
				for (DiagnosticCenter center : diagnosticCenters) {
					String centerId = center.getCenterId();
			%>
			<tr class="table-row">
				<td><%=center.getCenterId()%>
				<td><%=center.getCenterName()%>
				<td><%=center.getCenterAddress()%>
				<td><%=center.getContactNumber()%>
				<td><a href="AddTest.jsp?centerId=<%=centerId%>"><button>Add
							Test</button></a>
				<td><a href="RemoveTest.jsp?centerId=<%=centerId%>"><button>Remove
							Test</button></a>
				<td><a
					href="ApproveRejectAppointment.jsp?centerId=<%=centerId%>"><button>Approve
							Appointment</button></a>
				<td><a href="DeleteCenterServlet?centerId=<%=centerId%>"><button>Delete
							Center</button></a>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<footer>
		<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>
</body>
</html>