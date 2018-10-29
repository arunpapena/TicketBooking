<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgotPassword</title>
<script type="text/javascript">
function validateCurrentForm() {
    var y = document.forms["myForm"]["email"].value;
    if (y == "") {
        alert("email must be filled out");
        return false;
    }
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (reg.test(y) == false) 
    {
        alert('Invalid Email Address');
        return (false);
    }
    var z = document.forms["myForm"]["contact"].value;
    if (z == "") {
        alert("contact must be filled out");
        return false;
    }
   var reg1 = /^[1-9]{1}[0-9]{9}$/;
   if (reg1.test(z) == false) 
	   {
	   alert('Invalid contact');
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
<body background='https://images.pexels.com/photos/953214/pexels-photo-953214.jpeg?cs=srgb&dl=backgrounds-blank-blue-953214.jpg&fm=jpg'>
<center>
<h2 style="color:lavender">Fill below details to confirm account</h2>
<form:form modelAttribute="forgotPasswordDetails" name="myForm" action="forgotpassword" method="post" onsubmit="return validateCurrentForm()">
<table>
            <tr>
                <td style="color:lavender">Enter your mail:</td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td style="color:lavender">Enter your contact</td>
                <td><form:input path="contact"/></td>
                <td><form:errors path="contact" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr colspan=3 rowspan = 3>
                <td><input type="submit" name="submit" value="Register"></td>
            </tr>
        </table>
</form:form>
</center>
</body>
</html>