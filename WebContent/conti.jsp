<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.polimi.accounting.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Conto> conti = (List<Conto>) request.getAttribute("conti");
for (Conto conto : conti) {
	%>
	<p>
		<% out.write("Conto: " + conto.getNome() + "  saldo= " + conto.getSaldo()+"</p>"); %>
	</p>
	<%
}
%>
</body>
</html>