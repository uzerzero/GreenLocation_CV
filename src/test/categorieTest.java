package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.Categorie;

import org.junit.Before;
import org.junit.Test;

public class categorieTest {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();

	    Query q = em.createQuery("select c from Categorie c ");
	    
	   boolean creatNewEntries = (q.getResultList().size()==0);
	   if(creatNewEntries){
		   assertTrue(q.getResultList().size()==0);
		  			   
		    Categorie categorie = new Categorie();
		    categorie.setCaution(500);
		    categorie.setCO2(13);
		    categorie.setCoffreContenanceEnM3(3);
		    categorie.setNbPlaces(5);
		    categorie.setNbPortes(3);
		    categorie.setNom("petit");
		    categorie.setPrix(43);				
		  
		    em.persist(categorie);
		   
		    em.getTransaction().commit();
		    em.close();
	   }
	}

	@Test
	public void test() {		
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select c from Categorie c");
	    //(q.getResultList().size() ==15);
	    System.out.println("Count: "+q.getResultList().size());
	    System.out.println("essai");
	    em.close();
	}


}
