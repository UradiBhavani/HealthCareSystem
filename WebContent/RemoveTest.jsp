<%@page import="com.cg.hcs.entity.Test"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.hcs.service.AdminServiceImpl"%>
<%@page import="com.cg.hcs.service.IAdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type " text/css" href="LoginRegister.css">
<link rel="stylesheet" type " text/css" href="css/showCenters.css">
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
<div class="table-div">
	<%
		IAdminService adminService = new AdminServiceImpl();
		String centerId = request.getParameter("centerId");
		List<Test> listOfTests = adminService.viewAllTest(centerId);
		if(listOfTests!=null)
		{
			%>
			<h1>Center : <%=centerId %></h1>
			<table border="4" ,class="table-style" cellpadding="15%">
			<tr class="table-heading">
			<th>Test Id
			<th>Test Name
			</tr>
			<%for(Test test : listOfTests)
			{
				%>
				<tr class="table-row">
					<td><%=test.getTestId() %>
					<td><%=test.getTestName() %>
					<td><a href="RemoveTestServlet?testId=<%=test.getTestId()%>"><button>Remove</button></a>
				</tr>
			<%}%>
			</table>
		<%}
	%>
	</div>
</body>
</html>