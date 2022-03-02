<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div align ="center">
		<br><br>
		<h1>Welcome to admin page</h1>
		<form action="<%=request.getContextPath() %>/OptionPage" method= "post">
			<br><br>
			<button name="action" value="inputQuiz">Insert Questions</button>		<br><br>	
			<button name="action" value="takeQuiz">Take Quiz</button>
			
			<br><br>
			
		
		</form>
	
	</div>
	
</body>
</html>