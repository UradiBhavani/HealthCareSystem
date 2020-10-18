<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="LoginRegister.css">
</head>
<script>
	 function matchPassword() {

		var password = document.getElementById("newPassword").value;
		var confPassword = document.getElementById("confirmPassword").value;

		if (password == confPassword) {
			return true;
		}
		alert("Password and Confirm Password does not match");
		return false;
	} 
	
</script> 
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
			<li class="current"><a href="UserHomePage.jsp">Home</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<div class="box">
		<form action="ChangePasswordServlet" method="post" onsubmit = "return matchPassword()">
			<table>
				<td>Current Password:</td>
				<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input type="password" name="newPassword" id="password"></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="confirmPassword"
						id="password"></td>
				</tr>
				<tr>
					<input type="submit" name="Change Password" value = "Change Password" id="Change Password">
			</table>
		</form>
	</div>
	
</body>
	<footer>
	<p>@Health Care System, 2020, Developed by Group 4</p>
	</footer>
</body>
</html>