package it.overnet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.overnet.db.GestoreStudenti;

/**
 * Servlet implementation class ElencoStudentiController
 */
@WebServlet("/elencoStudenti")
public class ElencoStudentiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoStudentiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("elenco", GestoreStudenti.tutti());
		request.getRequestDispatcher("/WEB-INF/jsp/elencoStudenti.jsp").forward(request, response);
	}

}
