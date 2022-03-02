<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript">
		function validator(){
			var quesNo=document.getElementById("ques");
			
			if(quesNo.value=="" || quesNo.value>=10){
				alert("Must enter a number(less than 10)")
				return false;
			}
			else{
				return true;
			}
		}
	</script>

</head>
<body>

	<div align ="center">
		<br><br>
		<h1>Choose the number of Questions for Quiz</h1>
		<form onsubmit="return validator()" action="<%=request.getContextPath() %>/QuizServlet" method= "post">
			<br><br>
			<h1>10,15,20</h1>
			<table>
				<tr>
					<td>Enter : </td>
					<td><input id="ques" type ="text" name="totalQuestions" placeholder="Number of Questions"></td>
				</tr>
			</table>
			
			<br><br>
			<input type="submit" name ="SUBMIT">
		
		</form>
	
	</div>

</body>
</html>