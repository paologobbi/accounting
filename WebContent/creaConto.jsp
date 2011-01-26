<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>creaConto</title>
</head>
<body>
<legend>Tipo conto da creare</legend><br>
<form action="creaConto" method="post">
	<input type="checkbox" name="attivo"> Attivo <br>
	<input type="checkbox" name="passivo"> Passivo <br>
	<input type="checkbox" name="entrate"> Entrate <br>
	<input type="checkbox" name="uscite"> Uscite <br>	
	
	<p></p>
		<label>Nome da dare al conto creato <input type="text" name="nomeconto" value="<%
			String username = request.getParameter("nomeconto");%>"/>
			 </label>
			<p></p>


</form>



</body>
</html>