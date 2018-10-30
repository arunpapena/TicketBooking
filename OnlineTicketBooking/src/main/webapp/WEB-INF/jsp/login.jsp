<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
body{
margin-top: 250px;
 background-image: radial-gradient(red, yellow);
}
</style>
<script type="text/javascript">
var pass1 = document.forms["login"]["passwords"].value;
if(pass1.length==0){
	alert("password is required");
}

</script>
</head>
<body>
<center>
<h2>Login</h2>
<form:form name="login" modelAttribute="user" action="login" method="post">
<table>
            <tr>
                <td>Enter your mail:</td>
                <td><form:input type="email" path="email" name="email" /></td>
                <td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td>Enter a password:</td>
                <td><form:password path="password"  name="passwords" showPassword="true"/></td>
                <td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
            <tr>
            <tr>
                <a href="">Forget password?</a>
            </tr>         
            <tr colspan="3" rowspan ="3">
                <center><td><input type="submit" name="submit" value="Login"></td></center>
            </tr>
            
        </table>
</form:form>
</center>

</body>
</html>