package it.overnet.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisualizzaStudenteController
 */
@WebServlet("/visualizzaStudente")
public class VisualizzaStudenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStudenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// punti 2 e 3 dello schema
		Studente s = new Studente();
		s.setNome("Luigi");
		s.setCognome("Neri");;
		s.setDataNascita(new Date());
		s.setMatricola(886767);
		s.setCodiceFiscale("ABCDEF67T76A765T");
		// punto 4 dello schema
		request.setAttribute("studente", s);
		request.getRequestDispatcher("WEB-INF/jsp/visualizzaStudente.jsp").forward(request, response);
	}

}
