<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
var pass1 = document.forms["reset"]["newPassword"].value;
if(pass1.length==0){
	alert("password is required");
}
if(pass1.length<6){
	alert("password size must be between 6 to 16");
}
if(pass1.length>16){
	alert("password size must be between 6 to 16");
}

var pass2 = document.forms["reset"]["confirmPassword"].value;
if(pass2.length==0){
	alert("confirmed password is required");
}
if(!pass1.equals(pass2)){
	alert("new paswword and conform password doesn't match");
}

</script>
<title>update password</title>
</head>
<body>
	<center>
		<h1>Update Your temporary password to proceed</h1>
		
		<form:form name="reset" action="changepassword" modelAttribute="updatePassword"
			method="post">
			<table>
			<tr><td><form:hidden path="email" value="${ user }"></form:hidden></td></tr>
				<tr>
					<td>Enter your current Password:</td>
					<td><form:password path="currentPassword"></form:password></td>
					<td><form:errors path="currentPassword"
							cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Enter new password:</td>
					<td><form:password name="newPassword" path="newPassword" showPassword="true"/></td>
					<td><form:errors path="newPassword" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Conform new password:</td>
					<td><form:password name="confirmPassword" path="confirmPassword" showPassword="true"/></td>
					<td><form:errors path="confirmPassword"
							cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td colspan=3><input type="submit" name="submit"
						value="Update Password"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>