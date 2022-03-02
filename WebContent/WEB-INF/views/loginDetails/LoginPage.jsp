<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


	<script type="text/javascript">
		function validator(){
			var user=document.getElementById("uname");
			var pass=document.getElementById("pass");
			
			if(user.value.trim()=="" || pass.value.trim()==""){
				alert("Either Username or Password is blank, which is not allowed.")
				return false;
			}
			else if(pass.value.trim().length<5){
				alert("Password is too short must contain atleast 5 characters");
			}
			else{
				return true;
			}
		}
	</script>


</head>
<body>

	
	<br><br><br><br>
	
	<div align="center">
	
	<h1>Login Page</h1>
	<br><br>
	
		<form onsubmit="return validator()" action="<%=request.getContextPath() %>/LoginPage" method="post">
		<table style="with=80%">
			
			<tr>
				<th>User name : </th>
				<th><input id="uname" type="text" name="username"></th>
			</tr>
		
			<tr>
				<th>Password : </th>
				<th><input id="pass" type="password" name="password"></th>
			</tr>
			
			<tr>
				<td colspan ="2" align="center">
				</td>
			</tr>
			
		</table>
	
		<br><br>
			
		<input type="submit" value="LogIn">
			
	</form>
	
	</div>
	

</body>
</html>