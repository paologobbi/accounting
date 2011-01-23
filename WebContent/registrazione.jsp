<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" href="style.css" type="text/css" media="screen" /> 

<title>registrazione</title>
</head>
<body>
   Form per la registrazione nuovo utente:
   <p></p>

	<form action="registrazione" method="post">
		<label>Nome <input type="text" name="nome" value="<%
		String nome = request.getParameter("nome");
		if (nome!=null){
			out.print(nome);} %>" /></label>
		
		<p></p>
		<label>Cognome <input type="text" name="cognome" value="<% 
			String cognome = request.getParameter("cognome");
		    if (cognome!=null){
			out.print(cognome);}%>" /></label>
		<p></p>
		<!--  <label><input type="radio" name="gender" value="maschio" /> Maschio
	    <input type="radio" name="gender" value="femmina" /> Femmina</label>-->
	    <p></p>
		<label>Nome utente <input type="text" name="username" value="<%
			String username = request.getParameter("username");
			if (username!=null) {
			out.print(username);}%>" /></label>
			<p></p>
		<label>Password <input type="password" name="password" /></label>
		<p></p>
		<label>E-mail <input type="text" name="email" value="<% 
			String email= request.getParameter("email");
			if (email!=null) {
				out.print(email);}%>" /></label>
	    <p></p>
		<input type="submit" value="Registrazione" />
	</form>

	
</body>
</html>