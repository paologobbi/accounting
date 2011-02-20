package it.polimi.accounting;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreaTransazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaTransazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = (String) request.getSession().getAttribute("username");
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
	
			ContoDao insiemeDeiConti =new ContoDao(conn, username);
			int contoDaId=Integer.parseInt(request.getParameter("conto_da"));
			Conto contoDa=insiemeDeiConti.trovaConto(contoDaId);
			
			int contoAId=Integer.parseInt(request.getParameter("conto_a"));
			Conto contoA=insiemeDeiConti.trovaConto(contoAId);
			
			Transazione t=contoDa.trasferisciA(contoA, new BigDecimal(request.getParameter("importo")));
			
			t.setData((String) request.getParameter("AnnoTransazione")+"-"+request.getParameter("MeseTransazione")+"-"+request.getParameter("GiornoTransazione"));
			t.setCausale("causale");
			TransazioniDao nuovaTransazione = new TransazioniDao(conn,username);
			nuovaTransazione.creaTransazione(contoAId, contoDaId, t.getImporto(),t.getCausale(),t.getData());
			
		}catch  (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
