package it.overnet.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.Test;

import junit.framework.Assert;

public class JPATest {

	@Test
	public void test() {
		// 1. ottenere un entity manager factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBStudenti");
		// 2. ottenere un entity manager per gestire le nostre entità
		EntityManager em = emf.createEntityManager();
		
		Studente s = new Studente();
		s.setNome("Andrea");
		s.setCognome("Colleoni");
		try {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			Assert.assertTrue(s.getId() > 0);
		} catch (PersistenceException ex) {
			
		}
	}

}
