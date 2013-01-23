package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import modele.Utilisateur;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends Utilisateur implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "client")
	private final List<Reservation> reservations = new ArrayList<Reservation>();
	
	public List<Reservation> getReservations() {
	    return reservations;
	  }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Client() {
		super();
	}
   
}
