<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.polimi.accounting.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<label> Ciao <% out.print(session.getAttribute("username")); %></label> <br>
<p></p>
<select name="conto_da"><br>
<option> - Da conto - </option>
	
<% 	    
	List<String> conti = (List<String>) request.getAttribute("nomiConti");
	 for (int i=1; i<=conti.size();i++){
		 
	  
		out.print("<option value=\""+ i+"\">"+  conti.get(i) +"</option>\n");
	
	  
	  }
	  %>
	  <% String conto_da = request.getParameter("conto_da"); %>
	
	
	
</select>
<select name="conto_a"><br>
	<option> - A conto - </option> 
	<option value="1">paolo</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value=3>4</option>
	<option value="4">5</option>
</select>
<p></p>
<p></p>
<p></p>
 <p></p>
 <p></p>
		<label>Importo   <input type="text" name="importo" value="<%
			String importo = request.getParameter("importo");%>"/>
		 </label>
	<p></p>
 <p></p>
  <p></p>
 <p></p>
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
	
	<% String GiornoTransazioni = request.getParameter("GiornoTransazione"); %>
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
	<option value="2011">2011</option>
	<option value="2010">2010</option>
	<option value="2009">2009</option>
	<option value="2008">2008</option>
	<option value="2007">2007</option>
	<option value="2006">2006</option>
	<option value="2005">2005</option>
	<option value="2004">2004</option>
	<option value="2003">2003</option>
	<option value="2002">2002</option>
	<option value="2001">2001</option>
	<option value="2000">2000</option>
	</select>
	
 <p></p>
 
 <p></p>
		<input type="submit" value="Continua" />
		<input type="reset" value="Reset" />
		<input type="button" value="Back" onClick="history.go(-1);return true;">

</body>
</html>