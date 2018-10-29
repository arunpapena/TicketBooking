<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Source-Destination page</title>
<style>
 body{
    	background-image: url("images/source-destinationimage.jpg");
    }
   </style>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <script>
 $(document)
 .ready(
 		function() {
 			$("#idDate").datepicker({
 				minDate: 0});
 			
 		});
  </script>
</head>
<body>
<center style="padding:200px">
<h2>Choose Your Source And Destination</h2>
 
    <form:form method="GET" modelAttribute="sourceDestination" action="insertsourcedestination"  onsubmit="return validate();">
        <table cellpadding="5%">
            
            <tr>
                <td>From:</td>
                <td><form:select path="fromAddress" id="idFrom">
   				    <form:option value="vijayawada" />
   				    <form:option value="Kolkata" />
   				    <form:option value="Secunderabad" />
   				    <form:option value="Banglore" />
   				    <form:option value="Mumbai" />
   				    <form:option value="Delhi" />
   				    <form:option value="Pune" />
   				    <form:option value="Goa" />
   				    <form:option value="Punjab" />
   				    <form:option value="Kerala" />
				    </form:select></td>
                <td><form:errors path="fromAddress" cssStyle="color: #ff0000;" /></td>
            </tr>
            <tr>
                <td>To:</td>
                <td><form:select path="toAddress" id="idTo">
   				    <form:option value="vijayawada" />
   				    <form:option value="Kolkata" />
   				    <form:option value="Secunderabad" />
   				    <form:option value="Banglore" />
   				    <form:option value="Mumbai" />
   				    <form:option value="Delhi" />
   				    <form:option value="Pune" />
   				    <form:option value="Goa" />
   				    <form:option value="Punjab" />
   				    <form:option value="Kerala" />
				    </form:select></td>
                <td><form:errors path="toAddress" cssStyle="color: #ff0000;"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><form:input path="date" type="text" id="idDate" placeholder="mm/dd/yyyy" style="width:103px"/></td>
                <td><form:errors path="date" cssStyle="color: #ff0000;"/></td>
            </tr>
            <tr>
            	<td><input type="submit" name="submit" value="Register"></td>
            </tr>
        </table><span id="span"></span>
    </form:form>
    </center>
</body>
</html>