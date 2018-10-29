<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>

<style type="text/css">
body{
margin-top: 250px;
 background-image: radial-gradient(pink, skyblue);
}
</style>
</head>
<body>
<center>
<h2>Payment</h2>
<form:form modelAttribute="paymentDTO" action="save" method="post">
<table>

<tr>
                <td>Id:</td>
                <%-- <td><form:input path="id"/></td>
                <td><form:errors path="id" cssStyle="color: #ff0000;" /></td> --%>
                <td><input type="number" name="id" cssStyle="color: #ff0000;" required 
                oninvalid="this.setCustomValidity('Id cannot be empty.')" 
                   onchange="this.setCustomValidity('')"/></td>
            </tr>
             
            
            <tr>
                <td>Name:</td>
                <%-- <td><form:input path="name"/></td>
                <td><form:errors path="name" cssStyle="color: #ff0000;"  /></td> --%>
                <td><input type="text" name="name"  cssStyle="color: #ff0000;"></td>
            </tr>



            <tr>
                <td>Wallet:</td>
                <%-- <td><form:input path="wallet"/></td>
                <td><form:errors path="wallet" cssStyle="color: #ff0000;" /></td> --%>
                <td><input type="number" name="wallet"  cssStyle="color: #ff0000;" required></td>
            </tr>
			  <h4>Please Add Some Amount To Book Your Ticket...!!</h4>
            <tr>
                <td>Credit:</td>
                <%-- <td><form:input path="amount" /></td>
                <td><form:errors path="amount" cssStyle="color: #ff0000;"/></td> --%>
                <td><input type="number" name="amount"  cssStyle="color: #ff0000;" required
                oninvalid="this.setCustomValidity('Amount cannot be empty.')" 
                 onchange="this.setCustomValidity('')"/></td>
            <tr>         
            <tr colspan="3" rowspan ="3">
                <center><td><input type="submit" name="save" value="Submit"></td></center>
            </tr>
            
        </table>
</form:form>
</center>

</body>
</html>
