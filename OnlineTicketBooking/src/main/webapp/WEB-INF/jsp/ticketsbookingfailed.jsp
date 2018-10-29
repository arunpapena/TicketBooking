<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Failed</title>
<style>
	body{
		background-color: #D6EAF8  ;
	}
	center{
		padding: 10%;
	}
</style>
</head>
<body>
<center>
<div>
	<h1>Sorry You have no Sufficient Wallet Balance.</h1>
	<h1>Booking tickets for requested resource failed.</h1>
	<h1>Please Recharge your wallet</h1>
	<h1>present balance in your amount is : ${model.walletBalance}</h1>
</div>
</center>
</body>
</html>