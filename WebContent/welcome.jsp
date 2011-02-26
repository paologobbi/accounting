<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
<p> Ciao <% out.print(session.getAttribute("username")); %> il tuo login è stato effettuato</p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<a href="conti">Guarda i tuoi conti</a><br>
<p></p>
<a href="SaldoUtente">Guarda il tuo saldo</a><br>
<p></p>
<a href="transazioniPerIntervallo.jsp">Transazioni per date</a><br>
<p></p>
<a href="TutteTransazioni">Tutte le transazioni</a><br>
<p></p>
<a href="creaConto.jsp">Crea un altro conto</a><br>
<p></p>
<a href="CreaTransazione">Fai una transazione</a><br>
<p></p>


</body>

</html>