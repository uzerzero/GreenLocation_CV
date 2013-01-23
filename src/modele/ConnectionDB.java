package modele;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.Vehicule;

public class ConnectionDB {
	private EntityManagerFactory factory;
	private EntityManager em;
	 
	public ConnectionDB(String db) {
		factory = Persistence.createEntityManagerFactory(db);
		em = factory.createEntityManager();
	}
	 
	public void add(Vehicule v) {
		beginTransaction();
		em.persist(v);
		commitTransaction();
	}
	 
	public void del(Vehicule v) {
		beginTransaction();
		em.remove(v);
		commitTransaction();
	}
	public void add(Categorie c) {
		beginTransaction();
		em.persist(c);
		commitTransaction();
	}
	 
	public void del(Categorie c) {
		beginTransaction();
		em.remove(c);
		commitTransaction();
	}
	 
	@SuppressWarnings("rawtypes")
	public List getAll(String table) {
		String sql = "SELECT o FROM " + table + " o ";	
		return get(sql);
	}
	 
	@SuppressWarnings("rawtypes")
		public List get(String table, String champs, String value) {
		String sql = "SELECT o FROM " + table + " o WHERE " + champs + " = " + value;	 
		return get(sql);
	}
	 
	@SuppressWarnings("rawtypes")
		public List get(String sql) {
		Query query = em.createQuery(sql);	 
		return query.getResultList();
	}
	
	public void beginTransaction() {
		em.getTransaction().begin();
	}
	 
	public void commitTransaction() {
		em.getTransaction().commit();
	}
	 
	public void close() {
		em.close();
	}
}