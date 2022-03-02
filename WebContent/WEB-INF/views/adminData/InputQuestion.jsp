<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript">
		function validator(){
			var ques=document.getElementById("ques");
			var op1=document.getElementById("op1");
			var op2=document.getElementById("op2");
			var op3=document.getElementById("op3");
			var op4=document.getElementById("op4");
			var ans=document.getElementById("ans");
			
			if(ques.value=="" || op1.value=="" || op2.value=="" || op3.value=="" || op4.value=="" || ans.value==""){
				alert("One of the field is blank, Plaese fill the blank with appropriate String/Number")
				return false;
			}
			else{
				return true;
			}
		}
	</script>

</head>
<body>

	<%
	
		if(session.getAttribute("username")==null){
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login/LoginPage.jsp");
			dispatcher.forward(request, response);
			
		}
	
	%>
	
	<div align = "center">
		<h1>Insert Questions </h1>
	<form onsubmit="return validator()" action="<%=request.getContextPath() %>/InputQuestion" method= "post">
	<table style="with=100%">
	<tr>
		<td>Question : </td>
		<td><input id="ques" type="text" name="question" placeholder="Enter the Question"> </td>
	</tr>
	
	<tr>
		<td>Option 1 : </td>
		<td><input id="op1" type="text" name="option1" placeholder="Enter the Option 1"> </td>
	</tr>
	
	<tr>
		<td>Option 2 : </td>
		<td><input id="op2" type="text" name="option2" placeholder="Enter the Option 2"> </td>
	</tr>
	
	<tr>
		<td>Option 3 : </td>
		<td><input id="op3" type="text" name="option3" placeholder="Enter the Option 3"> </td>
	</tr>
	
	
	<tr>
		<td>Option 4 : </td>
		<td><input id="op4" type="text" name="option4" placeholder="Enter the Option 4"> </td>
	</tr>
	
	<tr>
		<td>Answer : </td>
		<td><input id="ans" type="text" name="answer" placeholder="Correct Option number"> </td>
	</tr>
	
	</table>
	
	<input type="submit" name="SUBMIT">
	
	</form>
	</div>

</body>
</html>