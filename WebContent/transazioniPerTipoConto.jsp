<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TransazioniTipoConto</title>
</head>
<body>
<form action="TransazioniTipoConto" method="post">
<label> Ciao <% out.print(session.getAttribute("username")); %>, su quale conto vuoi effettuare la ricerca</label> <br>
<p></p>
	<select name="TipoContoTransazioni">
		<option> - Conto - </option>
		<option value="attivo">Attivo</option>
		<option value="passivo">Passivo</option>
		<option value="entrate">Entrate</option>
		<option value="uscite">Uscite</option>
	
		<% String TipoContoTransazioni = request.getParameter("TipoContoTransazioni"); %>
	</select>
<p></p>
		<input type="submit" value="Continua" />
		<input type="reset" value="Reset" />
		<input type="button" value="Back" onClick="history.go(-1);return true;">
	

</body>
</html>