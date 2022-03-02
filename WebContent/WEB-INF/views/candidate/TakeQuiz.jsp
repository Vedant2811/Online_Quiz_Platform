<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body>

	<div align ="center">
		<form action="<%=request.getContextPath()%>/QuizServlet" method="post">
			<br><br><br>
			<h1>Quiz</h1>
			
		<table>
			<c:forEach begin ="0" end="5" items = "${list}" var = "question" varStatus="x">
			<tr>	
				<th>Question ${x.count} : </th>				
				<td>${question.questionText}</td>
			</tr>
			
			<tr>
				<th>Option 1 : </th>
				<td>${question.option1}</td>
			</tr>
			
			<tr>
				<th>Option 2 : </th>
				<td>${question.option2}</td>
			</tr>
			
			<tr>
				<th>Option 3 : </th>
				<td>${question.option3}</td>
			</tr>
			
			<tr>
				<th>Option 4 : </th>
				<td>${question.option4}</td>
			</tr>
			
			<tr>
				<th>Enter your answer : </th>
				<td><input type="text" name="userAnswer${x.index}" value="${question.userAnswer}" placeholder="Your Answer">
			</tr>
			<tr>
			<th></th>
			</tr>
		</c:forEach> 
			 
		</table>
		<br><br><br>
		<button type="submit" value="Submit">Submit</button>
		</form>
	</div>

</body>
</html>