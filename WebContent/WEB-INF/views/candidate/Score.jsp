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

	<div align="center">
		<form action="<%=request.getContextPath()%>/Score">
			<br><br><br>
			<h1>Your final Score is : <%=request.getAttribute("marks") %></h1>
			<br><br><br>
			<input type="submit" value="Back to main menu">
			
			<br><br><br>
			<script type="text/javascript">
				function mouseHover(){
					document.write("<h1>Onclicking this button this page will print</h1>");
					
				}
			</script>
			<button onclick="window.print()">Print your Score</button>
			<br><br>
		</form>
	</div>

</body>
</html>