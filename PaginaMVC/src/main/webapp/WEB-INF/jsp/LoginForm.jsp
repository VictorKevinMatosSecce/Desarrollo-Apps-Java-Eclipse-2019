<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<h3>Login Form</h3>
	<form action="login" method="POST">
	Usuario <br/>
	<input type="text" name="usuario">
	<br/>
	Contrasena<br/>
	<input type="password" name="contrasena">
	<br/><br/>
	<input type="submit" value="Login">
	</form>
</body>
</html>