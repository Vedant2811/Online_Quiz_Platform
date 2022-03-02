<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Quiz</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
<header>
	<div align="center">
	
	<form action="<%=request.getContextPath()%>/WelcomePage_Servlet" method="post">
	<br><br><br><br>
	<h1>Welcome, Select the action</h1><br>
<div class='button' >
    <button class="btn1" name="action" value="admin">1. Admin</button>
	<button class="btn1" name="action" value="takeQuiz">2. Take the Quiz</button>
</div>
	</form>
	
	</div>
</header>
</body>
</html>