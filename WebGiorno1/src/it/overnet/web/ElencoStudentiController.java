package it.overnet.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<Studente> elenco = new ArrayList<>();
		Studente s = new Studente();
		s.setNome("Mario");
		s.setCognome("Rossi");
		s.setMatricola(1234567);
		
		elenco.add(s);
		s = new Studente();
		s.setNome("Anna");
		s.setCognome("Bianchi");
		s.setMatricola(7654321);
		
		elenco.add(s);
		s = new Studente();
		s.setNome("Luisa");
		s.setCognome("Verdi");
		s.setMatricola(987123);
		
		elenco.add(s);
		request.setAttribute("elenco", elenco);
		request.getRequestDispatcher("/WEB-INF/jsp/elencoStudenti2.jsp").forward(request, response);
	}

}
