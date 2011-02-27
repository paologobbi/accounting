<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.polimi.accounting.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stile.css">

<title>Insert title here</title>
</head>
<body>
<form action="CreaTransazione" method="post">
<legend>FAI UNA TRANSAZIONE</legend>


<p></p>
<%List<Conto> conti= (List<Conto>) request.getAttribute("conti"); 
 %>

<select name="conto_da"><br>
	<option> - Da conto - </option> 

<%
 for (Conto conto:conti){
	%>
	<option value="<%out.print(conto.getId()); %>"><%out.print(conto.toString()); %></option>

	<%
}
%>
</select>
<select name="conto_a"><br>
	<option> - A conto - </option> 

<%
 for (Conto conto:conti){
	%>
	<option value="<%out.print(conto.getId()); %>"><%out.print(conto.toString()); %></option>

	<%
}
%>
</select>
 <p></p>


<label>Importo   <input type="text" name="importo" value="<%
			String importo = request.getParameter("importo");%>"/>
<p></p>
			
</label>
<label>Causale   <input type="text" name="causale" value="<%
			String causale = request.getParameter("causale");%>"/>
		 </label>
	<p></p>
 <p></p>

<label> Data    </label> 

	<select name="GiornoTransazione">
	<option> - Giorno - </option>
	<% 
	for (int i=1; i<=31;i++){
		out.print("<option value=\""+ i+"\">"+i+"</option>\n");
	}%>
	
	
</select>


<select name="MeseTransazione">
	<option> - Mese - </option>
	<option value="1">Gennaio</option>
	<option value="2">Febbraio</option>
	<option value="3">Marzo</option>
	<option value=3>Aprile</option>
	<option value="4">Maggio</option>
	<option value="6">Giugno</option>
	<option value="7">Luglio</option>
	<option value="8">Agosto</option>
	<option value="9">Settembre</option>
	<option value="10">Ottobre</option>
	<option value="11">Novembre</option>
	<option value="12">Dicembre</option>
</select>

<select name="AnnoTransazione">
	<option> - Anno - </option>
	<% 
	for (int i=2011; i>=2000;i--){
		out.print("<option value=\""+ i+"\">"+i+"</option>\n");
	}%>
	
	</select>
	
 <p></p>
 
 <p></p>
		<input type="submit" value="Continua" />
		<input type="reset" value="Reset" />
		<input type="button" value="Back" onClick="history.go(-1);return true;">
</form>
</body>
</html>