<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TransazioniDate</title>
</head>
<body>
<form action="TransazioniDate" method="post">
<label> Ciao <% out.print(session.getAttribute("username")); %></label> <br>
<p></p>
<label> Data inizio transazioni</label> <br>

	<select name="GiornoInizioTransazioni">
	<option> - Giorno - </option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
	<% String GiornoInizioTransazioni = request.getParameter("GiornoInizioTransazioni"); %>
</select>


<select name="MeseInizioTransazioni">
	<option> - Mese - </option>
	<option value="Gennaio">Gennaio</option>
	<option value="Febbraio">Febbraio</option>
	<option value="Marzo">Marzo</option>
	<option value="Aprile">Aprile</option>
	<option value="Maggio">Maggio</option>
	<option value="Giugno">Giugno</option>
	<option value="Luglio">Luglio</option>
	<option value="Agosto">Agosto</option>
	<option value="Settembre">Settembre</option>
	<option value="Ottobre">Ottobre</option>
	<option value="Novembre">Novembre</option>
	<option value="Dicembre">Dicembre</option>
</select>

<select name="AnnoInizioTransazioni">
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

<label> Data fine transazioni</label> <br>

	<select name="GiornoFineTransazioni">
	<option> - Giorno - </option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
</select>

<select name="MeseFineTransazioni">
	<option> - Mese - </option>
	<option value="Gennaio">Gennaio</option>
	<option value="Febbraio">Febbraio</option>
	<option value="Marzo">Marzo</option>
	<option value="Aprile">Aprile</option>
	<option value="Maggio">Maggio</option>
	<option value="Giugno">Giugno</option>
	<option value="Luglio">Luglio</option>
	<option value="Agosto">Agosto</option>
	<option value="Settembre">Settembre</option>
	<option value="Ottobre">Ottobre</option>
	<option value="Novembre">Novembre</option>
	<option value="Dicembre">Dicembre</option>
</select>

<select name="AnnoFineTransazioni">
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
		<input type="submit" value="Continua" />
		<input type="reset" value="Reset" />
		<input type="button" value="Back" onClick="history.go(-1);return true;">

	
		
		
</form>
</body>
</html>