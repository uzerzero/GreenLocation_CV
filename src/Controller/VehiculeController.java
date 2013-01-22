package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Vehicule;

public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static EntityManagerFactory factory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
				
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select v from Vehicule v");
	    List<Vehicule> vehiculeList = q.getResultList();
	    
	    /*for (Vehicule vehicule : vehiculeList) {
	      out.println("Vehicule: "+vehicule.getMarque()+" : "+vehicule.getModele()+" : " +vehicule.getCouleur());
	    }*/
	    
	    //viewVehiculeByID();
	    out.println("No de vehicule dans le DB: " + vehiculeList.size());
	    request.setAttribute("Vehicules", vehiculeList);
		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/Vehicules.jsp"); 
		dispatcher.forward(request, response);
	  }
	
	
	public static void viewVehiculeByID(){
		  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  EntityManager em = factory.createEntityManager();		  
		  Query q = em.createQuery( "SELECT v FROM Vehicule v WHERE v.id = '3'");
		  Vehicule v = (Vehicule)q.getSingleResult();		 
		  System.out.println("Vehicule: " + v.getMarque()+"</t> : "+v.getModele()+"</t> : "+v.getCouleur());
		  
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modeleStr=request.getParameter("ModeleTxt");
		String marqueStr=request.getParameter("MarqueTxt");
		String prixStr=request.getParameter("PrixTxt");
		PrintWriter out = response.getWriter();
		try { 
			int i = Integer.parseInt(prixStr); 
			} 
			catch (Exception e) { 
			prixStr="999999"; 
			}
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select v from Vehicule v where lower(v.modele) like lower('%"+modeleStr+"%') and lower(v.marque) like lower('%"+marqueStr+"%') and v.prix<="+prixStr);
	    List<Vehicule> vehiculeList = q.getResultList();
	    
	    /*for (Vehicule vehicule : vehiculeList) {
	      out.println("Vehicule: "+vehicule.getMarque()+"</t> : "+vehicule.getModele()+"</t> : " +vehicule.getCouleur());
	    }*/
	    
	    //viewVehiculeByID();
	    out.println("No de vehicule dans le DB: " + vehiculeList.size());
	    request.setAttribute("Vehicules", vehiculeList);
		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/Vehicules.jsp"); 
		dispatcher.forward(request, response);
	}

}
