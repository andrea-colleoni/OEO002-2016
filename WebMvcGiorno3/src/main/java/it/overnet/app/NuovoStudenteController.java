package it.overnet.app;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import it.overnet.db.Studente;
import it.overnet.db.StudenteDao;

public class NuovoStudenteController implements Controller {
	
	StudenteDao studenteDao;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if (request.getParameter("submit") == null || "".equals(request.getParameter("submit"))) {
			mv.setViewName("formStudente.jsp");
		} else {
			Studente s = new Studente();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			s.setNome(request.getParameter("nome"));
			s.setCognome(request.getParameter("cognome"));
			s.setDataNascita(sdf.parse(request.getParameter("dataNascita")));
			s.setAltezzaInCm(Integer.parseInt(request.getParameter("altezzaInCm")));
			s.setPesoInKg(Float.parseFloat(request.getParameter("pesoInKg")));
			s.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			studenteDao.salvaStudente(s);
			mv.addObject("elenco", studenteDao.tutti());
			mv.setViewName("elencoStudenti.jsp");			
		}
		
		return mv;
	}

	public StudenteDao getStudenteDao() {
		return studenteDao;
	}

	public void setStudenteDao(StudenteDao studenteDao) {
		this.studenteDao = studenteDao;
	}

}
