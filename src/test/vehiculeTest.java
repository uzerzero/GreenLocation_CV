package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.*;


import org.junit.Before;
import org.junit.Test;

public class vehiculeTest {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		
	    ConnectionDB cb = new ConnectionDB(PERSISTENCE_UNIT_NAME);
	    cb.beginTransaction();    	    
	    Categorie categorie = (Categorie) cb.get("Categorie", "id", "1");
	   for(int i=0;i<15;i++){
		    Vehicule vehicule = new Vehicule();
		    vehicule.setImmatriculation("CAT31_"+i);
			vehicule.setMarque("BMW_"+i);
			vehicule.setModele("Serie_"+i);
			vehicule.setCouleur("Rouge_"+i);
			vehicule.setDisponibilite("dispo");
		    vehicule.setCategorie(categorie);
		    cb.add(vehicule);
	   }		
	   cb.close();
		
	}

	@Test
	public void test() {	
		
		/*
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select v from Vehicule v");
	    assertTrue(q.getResultList().size() ==15);
	    System.out.println("Count: "+q.getResultList().size());
	    System.out.println("essai");
	    em.close();*/
	}


}
