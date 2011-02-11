package it.polimi.accounting;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransazioniDate
 */
public class TransazioniDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TransazioniDate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");

		String dataInizio = (String) request.getParameter("AnnoInizioTransazioni")+"-"+request.getParameter("MeseInizioTransazioni")+"-"+request.getParameter("GiornoInizioTransazioni");
		String dataFine = (String) request.getParameter("AnnoFineTransazioni")+"-"+request.getParameter("MeseFineTransazioni")+"-"+request.getParameter("GiornoFineTransazioni");
		System.out.println(dataInizio);
		System.out.println(dataFine); 

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			TransazioniDao insiemeTransazioni = new TransazioniDao(conn, username);
			List<Transazione> transazioni =insiemeTransazioni.transazioniPerDate(dataInizio, dataFine);
			
			request.setAttribute("transazioni", transazioni);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mostraTransazioni.jsp");
			dispatcher.forward(request, response);
			} catch (SQLException e){
				e.printStackTrace();
	}

	

}}
