package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Contrat implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id 
		@GeneratedValue(strategy=GenerationType.TABLE)
		private long id;
		@Temporal(TemporalType.DATE)
		private Date dateSaisie;
		public Date getDateSaisie() {
			return dateSaisie;
		}

		public void setDateSaisie(Date dateSaisie) {
			this.dateSaisie = dateSaisie;
		}
		private Employe employe;
		
	    private Reservation reservation;		
		
	    @OneToOne
		public Reservation getReservation() {
			return reservation;
		}
		
		@ManyToOne
		public Employe getEmploye() {
			return employe;
		}
		
		public void setEmploye(Employe employe) {
			this.employe = employe;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}

	
}
