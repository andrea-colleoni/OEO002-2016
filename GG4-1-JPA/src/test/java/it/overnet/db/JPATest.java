package it.overnet.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class JPATest {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	@Before
	public void inizializza() {
		// 1. ottenere un entity manager factory
		emf = Persistence.createEntityManagerFactory("DBStudenti");
		// 2. ottenere un entity manager per gestire le nostre entità
		em = emf.createEntityManager();		
	}

	@Test
	public void testNuovoStudente() {	
		Studente s = new Studente();
		s.setNome("Test 1");
		s.setCognome("Test 1");
		s.setDataNascita(new Date());
		try {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			Assert.assertTrue("Id correttamente valorizzato: " + s.getId(), s.getId() > 0);
		} catch (PersistenceException ex) {
			
		}
	}
	
	@Test
	public void testElencoStudenti() {
		TypedQuery<Studente> q = em.createQuery("Select st From Studente st", Studente.class);
		List<Studente> elenco = q.getResultList();
		Assert.assertTrue(elenco.size() > 0);
	}
	
	@Test
	public void testModificaStudente() {
		Studente s = em.find(Studente.class, 7);
		Assert.assertTrue("Fabio".equals(s.getNome()));
		s.setCognome("Modificato");
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	@Test
	public void eliminaStudente() {
		Studente s = em.find(Studente.class, 17);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
	}
	
	@Test
	public void iscrizione() {
		Studente s = new Studente();
		s.setNome("Test 1");
		s.setCognome("Test 1");
		
		Corso c = new Corso();
		c.setTitolo("Java Web");
		c.setDurataInOre(28);
		c.setDataInizio(new Date());
		
		c.addIscritto(s);
		
		em.getTransaction().begin();
		em.persist(s);
		em.persist(c);
		em.getTransaction().commit();		
	}
	
	@Test
	public void mostraPianoDiStudi() {
		Studente s = em.find(Studente.class, 2);
		
		Corso c = new Corso();
		c.setTitolo("Corso di test");;
		
		s.addCorsoToPianoDiStudi(c);
		em.getTransaction().begin();
		em.persist(s);
		em.persist(c);
		em.getTransaction().commit();	
		
		for(Corso cs : s.getPianoDiStudi()) {
			System.out.println(cs.getTitolo());
		}
		
		Assert.assertTrue(s.getPianoDiStudi().get(0).getTitolo().equals("Java Web"));
	}
	
	@Test
	public void queryComplessa() {
		TypedQuery<Studente> q = em.createQuery("Select st From Studente st", Studente.class);
		Corso jw = em.createQuery("Select c From Corso c Where c.titolo='Java Web'", Corso.class).getSingleResult();
		Corso ct = em.createQuery("Select c From Corso c Where c.titolo='Corso di test'", Corso.class).getSingleResult();
		List<Studente> result = new ArrayList<>();
		q.getResultList()
				.stream()
				.filter(st -> st.getPianoDiStudi().contains(jw) && !st.getPianoDiStudi().contains(ct))
				.forEach(result::add);
		System.out.println(result.size());
	}
	
}
