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
<form action="CreaConto" method="post">

	<input type="radio" name="tipoConto"  value="Attivo" /> Attivo <br>
	<input type="radio" name="tipoConto" value="Passivo" /> Passivo<br>
	<input type="radio" name="tipoConto" value="Entrate" /> Entrate<br>
	<input type="radio" name="tipoConto" value="Uscite" /> Uscite<br>	
	
	<p></p>
		<label>Nome da dare al conto creato <input type="text" name="nomeConto" value="<%
			String nomeConto = request.getParameter("nomeConto");%>"/>
		 </label>
	<p></p>
	<p></p>
		<label>Saldo Iniziale Conto <input type="text" name="saldoIniziale" value="<%
			String saldoIniziale = request.getParameter("saldoIniziale");%>"/>
		 </label>
			<p></p>

<p></p>
		<input type="submit" value="Continua" />
		<input type="reset" value="Reset" />
		<input type="button" value="Back" onClick="history.go(-1);return true;">
</form>



</body>
</html>