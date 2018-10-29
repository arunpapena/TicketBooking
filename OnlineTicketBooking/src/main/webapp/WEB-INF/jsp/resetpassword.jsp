<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ResetPassword</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#contact").hide();
	$("#email").hide();
	
});
function validateCurrentFormtwo() {
    var reg = /^([a-zA-Z0-9@*#]{8,15})$/;
    var y = document.forms["myForm"]["password"].value;
    if (reg.test(y) == false) 
    {
        alert('password should be atleast 8 to 15');
        return (false);
    }
    var z = document.forms["myForm"]["confirmpassword"].value;
    if (z.equals(y) == false) 
    {
        alert('password didnt match');
        return (false);
    }
}
</script>
<style type="text/css">
body{
margin-top: 250px;
}
</style>
</head>
<body background="https://d2v9y0dukr6mq2.cloudfront.net/video/thumbnail/H8WuRINimqur8ud/technology-background-gear_rhfg-imn_thumbnail-full01.png">
<center>
<h2 style="color:lavender">Fill below details to confirm account</h2>
<form:form modelAttribute="setPassword" name="myForm" action="resetpassword" method="post" onsubmit="return validateCurrentFormtwo()">
<table>
			 <tr id="email" style="display: none;">
                <td style="color:lavender"/>
                <td><form:input path="email" value="${session.getAttribute('email')}" />
                <td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr id="contact" style="display: none;">
                <td style="color:lavender"/>
                <td><form:input path="contact" value="${session.getAttribute('contact')}" />
                <td><form:errors path="contact" cssStyle="color: #ff0000;" />
            </tr>
            <tr>
                <td style="color:lavender">Enter your password:</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td style="color:lavender">Confirm your password</td>
                <td><form:password path="confirmpassword"/></td>
                <td><form:errors path="confirmpassword" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr colspan=3 rowspan =3>
                <td><input type="submit" name="submit" value="Register"></td>
            </tr>
        </table>
</form:form>
</center>
</body>
</html>