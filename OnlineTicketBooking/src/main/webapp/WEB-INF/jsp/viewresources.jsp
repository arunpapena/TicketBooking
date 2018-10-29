<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Resources</title>
<style>
    body{
    	background-image: url("images/source-destinationimage.jpg");
    }
    center{
    	padding:10%;
    }
</style>
</head>
<body>
<center>
<h1>Available Resources:</h1>
<table border="2" width="50%" cellpadding="2" style="text-align:center">  
<tr><th>BusNO</th><th> Bus Name</th><th>Source Station</th><th>Arrival Time</th><th>Destination Station</th><th>Departure Time</th><th>Price</th><th>SELECT</th></tr> 
	 <c:forEach var="busInfo" items="${list}">
	 <form:form method="post" modelAttribute="busInfo" action="bookingpage">
	 <input type="text" value="${busInfo.busNo}" name="busNo" style="display: none;"/> 
	 <tr>
	 	<td><input type="text" value="${busInfo.busNo}" name="busNoo" disabled="disabled"/></td>
	 	<td>${busInfo.busName}</td>
	 	<td>${busInfo.sourceStn}</td>
	 	<td>${busInfo.arrivalTime}</td>           
	 	<td>${busInfo.destinationStn}</td>
	 	<td>${busInfo.departureTime}</td>
	 	<td>${busInfo.price}</td>
	 	<td><input type="submit" value="SELECT"/></td>
	 </tr>
	 </form:form>
	 </c:forEach>
	 </table>

</center>
</body>
</html>