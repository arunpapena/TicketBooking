<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript">
	var name = document.forms["profile"]["name"].value;
	var con = document.forms["profile"]["contact"].value;
	if (name.length == 0) {
		alert("name field can't be left blank");
	}
	if (name.length < 3) {
		alert("name is too short");
	}
	if (con.length == 0) {
		alert("contact field can't be left blank");
	}
	if (con.length != 10 || con.length != 12) {
		alert("contact is not valid");
	}
	
	$(document).ready(function(){
		$("#recharge").click(function(){
			$("#rechargeField").toggle();
		});
	});
	$(document).ready(function(){
		$("#rech").click(function(){
			$("#rechargeField").toggle();
		});
	});
</script>
</head>
<body>
	<center>
		<form:form name="profile" action="changeRecord"
			modelAttribute="updateRecord" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input name="name" path="name"
							value="${ user.getName() }" /></td>
					<td><form:errors path="name" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><form:input name="contact" path="contact"
							value="${ user.getContact() }" /></td>
					<td><form:errors path="contact" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Email ID:</td>
					<td><form:input name="email" type="email" path="email"
							value="${ user.getEmail() }" enabled="false" /></td>
					<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="Submit" value="save Details"
						name="save" /></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Logout" name="logout" /></td>
				</tr>
			</table>
			
		</form:form>
	</center>
</body>
</html>