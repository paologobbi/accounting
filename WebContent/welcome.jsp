<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>welcome</title>
</head>
<link rel="stylesheet" type="text/css" href="stile.css">

<style>
body {
  padding-left: 20em;
  </style>
<body>
<h1> Benvenuto <% out.print(session.getAttribute("username")); %> </h1>
<p> Grazie per esserti connesso ad ACCOUNTING</p>
<p>
<!-- Menu di navigazione -->
<ul class="navbar">
  <li><a href="conti">Guarda i tuoi conti</a>
  <li><a href="transazioniPerIntervallo.jsp">Transazioni per date</a>
  <li><a href="TutteTransazioni">Tutte le transazioni</a>
  <li><a href="creaConto.jsp">Crea un altro conto</a>
  <li><a href="CreaTransazione">Fai una transazione</a>
</ul>



</body>

</html>