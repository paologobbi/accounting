package it.polimi.accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ResultSet risultato;
		try {
			Connection conn =
			       DriverManager.getConnection("jdbc:mysql://localhost/accounting?user=root&password=");
			PreparedStatement	stmt = conn.prepareStatement("SELECT * FROM utente WHERE username=?");	
			stmt.setString(1, username);
			
			risultato=stmt.executeQuery();
		} catch (SQLException e){
			response.getWriter().print("C'è un errore sulla connessione, riprovare più tardi!");
		return;
		}
		
			try {
			risultato.next();
			
		String expectedPassword = risultato.getString("password");
		
		if (expectedPassword.equals(password)){
				request.getSession().setAttribute("username", username);
				response.sendRedirect("welcome.jsp");
				return;
			}
		
			else  { 
			
				 request.setAttribute("messaggio", "Username o password non corretta, impossibile effettuare il login!");
					
					 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

				     dispatcher.forward(request, response);
					
				} 
		 
		} catch (SQLException e) {
			request.setAttribute("messaggio", "Username o password non corretta, impossibile effettuare il login! ");
			
			 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

		     dispatcher.forward(request, response);
			
		}
		
	} 

}
