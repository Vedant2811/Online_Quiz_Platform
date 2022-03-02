<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>

	<script type="text/javascript">
		function validator(){
			var candiName=document.getElementById("cName");
			var mobNo=document.getElementById("mobNmbr");
			
			if(candiName.value.trim()==""){
				alert("Candidatte Name is blank, which is not allowed.")
				return false;
			}
			else if(mobNo.value.trim()==""){
				alert("Mobile Number is blank, which is not allowed");
				return false;
			}
			else if(mobNo.value.trim().length!=10){
				alert("Mobile Number is not appropriate, must contain 10 digits only");
				return false;
			}
			else{
				return true;
			}
		}
	</script>

</head>
<body>
	
	<div align = "center">
		<br><br><br>
		
		<h1>Candidate Data </h1>
	<form onsubmit="return validator()" action="<%=request.getContextPath() %>/CandidateData" method= "post">
	<table style="with=100%">
	<tr>
		<td>Name of Candidate : </td>
		<td><input type="text" id="cName" name="candidateName" placeholder="Name of Candidate"> </td>
	</tr>
	
	<tr>
		<td>Mobile Number : </td>
		<td><input type="text" id="mobNmbr" name="mobileNumber" placeholder="Mobile Number of Candidate"> </td>
	</tr>
	

	</table>
	
	<input type="submit" name="SUBMIT">
	
	</form>
	</div>
	
</body>
</html>