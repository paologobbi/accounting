<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.polimi.accounting.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=2, cell> 
	<tr bgcolor=#00c196>
       <td width=100>Nome</td>
       <td width=100>Saldo</td>
       
   </tr>
<%
List<Conto> conti = (List<Conto>) request.getAttribute("conti");
for (Conto conto : conti) {
	%>
	<tr>
       <td align="center"><% out.print(conto.getNome());%></td>
       <td align="center"><% out.print(conto.getSaldo());%></td>
       
   </tr>
	
	<%
}
%>
</body>
</html>