<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" href="style.css" type="text/css" media="screen" /> 

<title>Login</title>
</head>
<body>
<form action="login" method="post"> 
<label>Nome utente <input type="text" name="username" value="<% out.print(request.getParameter("username")); %>" /></label>
<label>Password <input type="password" name="password" /></label>
<input type="submit" value="Login" />


</form>

</body>
</html>