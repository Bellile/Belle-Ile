package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

	/*
	 * Déclaration de l'association uml en java
	 */

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	
	@OneToMany(mappedBy="reservation")
	private List<Accompagnant> listeAccompagnant;
	
	@ManyToOne
	@JoinColumn(name="offre_id", referencedColumnName="id_offre")
	private Offre offre;
	
	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id_location",nullable=true)
	private LocationVoiture location;

	
	
	// attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resa")
	private int id_resa;
	private int nbrePlace;
	
	private double prixTotal;

	// constructeur
	public Reservation() {
		super();
	}

	public Reservation(int nbrePlace) {
		super();
		this.nbrePlace = nbrePlace;
	}
	
	public Reservation(int id_resa, int nbrePlace) {
		super();
		this.id_resa = id_resa;
		this.nbrePlace = nbrePlace;
	}


	// getter et setter
	public int getId_resa() {
		return id_resa;
	}

	public void setId_resa(int id_resa) {
		this.id_resa = id_resa;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Accompagnant> getListeAccompagnant() {
		return listeAccompagnant;
	}

	public void setListeAccompagnant(List<Accompagnant> listeAccompagnant) {
		this.listeAccompagnant = listeAccompagnant;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public int getNbrePlace() {
		return nbrePlace;
	}

	public void setNbrePlace(int nbrePlace) {
		this.nbrePlace = nbrePlace;
	}

	public LocationVoiture getLocation() {
		return location;
	}

	public void setLocation(LocationVoiture location) {
		this.location = location;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	@Override
	public String toString() {
		return "Reservation [id_resa=" + id_resa + ", nbrePlace=" + nbrePlace + ", prixTotal=" + prixTotal + "]";
	}

	
}
