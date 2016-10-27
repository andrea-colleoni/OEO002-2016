package it.overnet.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import it.overnet.db.StudenteDao;

public class ElencoStudentiController implements Controller {

	StudenteDao studenteDao;
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("elenco", studenteDao.tutti());
		mv.setViewName("elencoStudenti.jsp");
		return mv;
	}

	public StudenteDao getStudenteDao() {
		return studenteDao;
	}

	public void setStudenteDao(StudenteDao studenteDao) {
		this.studenteDao = studenteDao;
	}

}
