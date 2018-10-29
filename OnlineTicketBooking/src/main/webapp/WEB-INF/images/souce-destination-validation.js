function validate(){
	
	var fromAdd=document.getElementById("idFrom").val();
	var toAdd=document.getElementById("idTo").val()
	if(fromAdd.equals(toAdd))
	{
		document.getElementById("span").innerHTML="<p style='color:red'>You had given the same source and destination.</p>";return false;
	}
	
}