<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Page</title>
<style>
	 table{
        width: 30%;
        margin-bottom: 20px;
		border-collapse: collapse;
    }
    table, th, td{
        border: 1px solid #cdcdcd;
    }
    table th, table td{
        padding: 10px;
        text-align: center;
    }
    body{
    	background-image: url("images/source-destinationimage.jpg");
    }
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document)
.ready(
		function() {
			
			
			$("#btnpay").click(function(){
						
				var pricePerTicket=$("#slctPassenger").attr("name");
				var noOfTickets=$("#slctPassenger").val();
				var wallet=$("#idWallet").html();
				window.location.href = "/OnlineTicketBooking/checkingwallet/"+pricePerTicket+"/"+noOfTickets+"/"+wallet+"/"; 
				
			});
			
			
			
			$("#btnProceed").click(function(){
				var count=$("#slctPassenger").val();
				var errorCount=0;
				for(var i=0;i<count;i++)
				{
					var name = $("#txtName"+i).val();
            		var age= $("#txtAge"+i).val();
            		if(name==""||age=="")
            		{
            			errorCount+=1;
            			$("#divError").text("please fill total passenger details");
            		}
            		if(!$.isNumeric( age ))
            		{
            			errorCount+=1;
            			$("#divError").text("please enter valid age details");
            		}
            		if($.isNumeric( name ))
            		{
            			errorCount+=1;
            			$("#divError").text("please enter valid names");
            		}
            		
				}
				if(errorCount==0)
				{
				for(var i=0;i<count;i++)
				{
					var name = $("#txtName"+i).val();
            		var age= $("#txtAge"+i).val();
           	 		var markup = "<tr><td>" + name + "</td><td>" + age + "</td></tr>";
            		$("#tbPassenger").append(markup);
            		$.ajax({
						type : "POST",
						url : "/OnlineTicketBooking/inserttopassenger",
						async : "true",
						data : {
							"name":name,
							"age":age,
						},
						success : function(
								response) {
							$("#divError").text('');
							$("#passengerForm").hide();
							$("#h1EnteredInfo").show();
							$("#h1EnterInfo").hide();
							$("#passengerInfoTable").show();
							$("#btnpay").show();
						},
						error : function(
								response) {
							alert("Error occured while inserting passengers into database:"+response);
						
						}
					
					});  
				}
				}
			});			
			
			
					$( "select" ) .change(function () {
						
									$("#passengerForm").show();
									$("#btnpay").hide();
									$("#passengerInfoTable").hide();
									$("#h1EnteredInfo").hide();
									$("#h1EnterInfo").show();
									var price=$(this).attr("name");
   									 var noOfTickets = "";
   									var txt="";
   			
									 	$("#divTextBox").empty();
									 	$("#divTextBox1").empty();
									 	$("#tbPassenger").empty();
   									
    								$( "select option:selected" ).each(function() {
    									noOfTickets = $( this ).text() ;
    									for(i = 0; i <noOfTickets ; i++) { 
    										
    										
    										$("#divTextBox").append("<div><br><label>Passenger"+ (i+1) +"<label/><br></div>");
    											$("#divTextBox").append("<div><br><input type='text' placeholder='Name' name='txtName"+i+"' id='txtName"+i+"'/><br></div>");
    											$("#divTextBox1").append("<div><br><label><label/><br></div>");	
    											$("#divTextBox1").append("<div><br><input type='text' placeholder='Age' name='txtAge"+i+"' id='txtAge"+i+"'/><br></div>");
    										}
    										$.ajax({
    										type : "POST",    									
    										url : "/OnlineTicketBooking/pricecal",
    										async : "true",
    										data : {
    											"noOfTickets" : noOfTickets,
    											"price":price,
    										},
    										success : function(
    												response) {
    											$("."+price) . text (response+" RS/-");
    										},
    										error : function(
    												response) {
    											alert("Error occured while calculating price:"+response);
    											
    										}
    										
    									}); 
  								  });					
    									
 					 })
 			 .change();
					
		});
</script>
</head>
<body>
<h1>User Details:</h1><br/>
<table id="tblUser">
<tr><th>UserId</th><th>UserName</th><th>WalletBalance</th></tr>
<tr><td>${model.userId}</td><td>${model.firstName}</td><td id="idWallet">${model.wallet}</td></tr>
</table>
<h1>Bus Info is:</h1>
<table id="tblBUsInfo" width="50%">
<tr><th>Bus Number</th><th>Bus Name</th><th>Source</th><th>Arrival Time</th><th>Destination</th><th>Departure Time</th><th>CostPerTicket</th><th>No.Of Tickets</th><th>Price</th></tr>
<c:forEach var="busInfo" items="${model.list}">
<%-- <p>Bus Number         : ${busInfo.busNo}</p>
<p>Bus Name           : ${busInfo.busName}</p>
<p>Source             : ${busInfo.sourceStn}</p>
<p>Arrival Time       : ${busInfo.arrivalTime}</p>
<p>Destination        : ${busInfo.destinationStn}</p>
<p>Departure Time     : ${busInfo.departureTime}</p>
<p id="${busInfo.price}">Cost per One Ticket: ${busInfo.price}</p> --%>
<tr>
<td>${busInfo.busNo}</td>
<td>${busInfo.busName}</td>
<td>${busInfo.sourceStn}</td>
<td>${busInfo.arrivalTime}</td>
<td>${busInfo.destinationStn}</td>
<td>${busInfo.departureTime}</td>
<td id="${busInfo.price}">${busInfo.price}</td>


<td><select id="slctPassenger" name="${busInfo.price}" >
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
</select></td>

<td><h1 class="${busInfo.price}"></h1></td>
</tr>

</c:forEach>
</table>
<h1 id="h1EnterInfo">Enter Passengers Info:</h1>
     	<form id="passengerForm" style="width: 20%" action="inserttopassenger">
       	<div id="divTextBox" style="float: left"></div>
       	<div id="divTextBox1" style="float: right"></div>
       	<input id="btnProceed" type="button" class="add-row" value="proceed" style="margin-left:5%;margin-top:20px" >
       	</form><br><br><br>
 <h1 id="h1EnteredInfo" style="display:none">Passengers Info</h1>     
	<table id="passengerInfoTable" Style="border:1 px solid black;padding:2 px;display:none">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody id="tbPassenger">
            
        </tbody> 
    </table>  
       <div id="divError" style="color:red"></div>
       
       <button id="btnChangeDetails" style="margin-left:5%;display:none">ChangeDetails</button>
       
       <button id="btnpay" style="margin-left:5%;display:none">PROCEEDPAYMENT</button>
         
      
</body>
</html>