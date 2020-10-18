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
<style>
/* .dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;} */
</style>
<link rel="stylesheet" type="text/css" href="LoginRegister.css">
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
			<li><a href="ShowDiagnosticCenterServlet">Make Appointment</a></li>
			<li><a href="CheckAppointmentStatusServlet">Check
					Appointment Status</a></li>
			<div class="dropdown">
		<button class="dropbtn">
			Welcome
			<%= session.getAttribute("userId")%></button>
		<div class="dropdown-content">
			<a href="editProfile.jsp">Edit Profile</a> <a
				href="changePassword.jsp">Change Password</a> <a
				href="LogoutServlet">Logout</a>
		</div>
	</div>
		

		</ul>
		</nav>
		
	</div>
	</header>
	<script>
			<%if (request.getAttribute("successMessage") != null) {%>
				setTimeout(
						function() {

							document.getElementById("successMessage").style.display = "none";
						}, 5000);
			<%request.setAttribute("successMessage", null);

			}%>
	</script>
	
	<footer>
	<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>
</body>
</html>