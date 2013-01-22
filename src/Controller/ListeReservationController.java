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

import modele.Reservation;;

/**
 * Servlet implementation class ListeReservationController
 */
@WebServlet("/ListeReservationController")
public class ListeReservationController extends HttpServlet {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory factory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeReservationController() {
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
	    Query q = em.createQuery("select v from Reservation v");
	    List<Reservation> reservationList = q.getResultList();
	   
	    out.println("No de reservation dans le DB: " + reservationList.size());
	    request.setAttribute("Reservations", reservationList);
		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/Reservation.jsp"); 
		dispatcher.forward(request, response);
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String utilisateurStr=request.getParameter("UtilisateurTxt");
		String modeleStr=request.getParameter("ModeleTxt");
		String marqueStr=request.getParameter("MarqueTxt");
		String dateStr=request.getParameter("DateTxt");
		PrintWriter out = response.getWriter();
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select v from Reservation v where lower(v.loginUtilisateur) like lower('%"+utilisateurStr+"%') and lower(v.modeleVehicule) like lower('%"+modeleStr+"%') and lower(v.marqueVehicule) like lower('%"+marqueStr+"%') and (v.dateDebut like ('%"+dateStr+"%') or v.dateFin like ('%"+dateStr+"%'))");
	    List<Reservation> reservationList = q.getResultList();
	    
	    /*for (Vehicule vehicule : vehiculeList) {
	      out.println("Vehicule: "+vehicule.getMarque()+"</t> : "+vehicule.getModele()+"</t> : " +vehicule.getCouleur());
	    }*/
	    
	    //viewVehiculeByID();
	   // out.println("No de vehicule dans le DB: " + vehiculeList.size());
	    request.setAttribute("Reservations", reservationList);
		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/listeReservation.jsp"); 
		dispatcher.forward(request, response);
	}


}
