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
<% 
  if (request.getAttribute("messaggio")!=null){
	  out.print (request.getAttribute("messaggio"));
	  }%>
  
<form action="login" method="post"> 
Login
<label>Nome utente <input type="text" name="username" value="<%
	String username = request.getParameter("username");
	if (username!=null) {
	out.print(username);}%>" /></label>
<label>Password <input type="password" name="password" /></label>
<input type="submit" value="Login" />
<p></p>

Se non sei un utente registrato clicca <a href="registrazione.jsp">QUI</a>

</form>

</body>
</html>