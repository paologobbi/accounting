<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.polimi.accounting.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=2, cell> 
	<tr bgcolor=#00c196>
       <td width=40>Id</td>
       <td width=100>Da Conto</td>
       <td width=100>A Conto</td>
       <td width=150>Importo</td>
       <td width=350>Causale</td>
       <td width=80>Data</td>
   </tr>
<%
List<Transazione> transazioni = (List<Transazione>) request.getAttribute("transazioni");
for (Transazione transazione : transazioni) {
	%>
	
	<tr>
       <td align="center"><% out.print(transazione.getId());%></td>
       <td align="center"><% out.print(transazione.getContoDa());%></td>
       <td align="center"><% out.print(transazione.getContoA());%></td>
       <td align="center"><% out.print(transazione.getImporto());%></td>
       <td align="center"><% out.print(transazione.getCausale());%></td>
       <td align="center"><% out.print(transazione.getData());%></td>
   </tr>
	
	 
	<%
}
%>
</TABLE>
</body>
</html>
