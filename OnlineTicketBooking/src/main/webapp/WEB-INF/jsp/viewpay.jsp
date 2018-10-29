<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
<h1>View Payment List</h1>
<form action="./success" method="post">
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Wallet</th><th>Amount</th><th>Total</th></tr>
    <c:forEach var="paymentDTO" items="${List}"> 
    <tr>
    <td>${paymentDTO.id}</td>
    <td>${paymentDTO.name}</td>
    <td>${paymentDTO.wallet}</td>
    <td>${paymentDTO.amount}</td>
    <td>${paymentDTO.amount+paymentDTO.wallet}</td>
    </tr>
    </c:forEach>
</table>
	<br>
   <center><input type="submit"  value="Book"></center>
   <br>
    <a href="http://localhost:8080/Buspayment/">Click Here to go Back</a>
    <h2 style="margin-top: 357px; color:red;">  NOTE*: If You Want to Book A Ticket Amount Should be More Than 1250*</h2>  
 </form>      
 </body>
 </html>